package builder

import components.Answer
import components.Factor
import components.Problem
import components.Variable
import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.canvas.Canvas
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.util.StringConverter

class SimpleTabBuilder : TabBuilder {

    override fun buildTab(problem: Problem): Tab =
        Tab(problem.label, buildTabContent(problem)).apply { isClosable = false }

    private fun buildTabContent(problem: Problem) : VBox =
        VBox(20.0).apply {
            alignment = Pos.CENTER
            children.setAll(
                buildProblem(problem)
            )
        }

    private fun buildProblem(problem: Problem): List<Node> =
        mutableListOf(
            buildProblemPicture(problem),
            buildProblemText(problem),
            *buildProblemFields(problem)
        )

    private fun buildProblemPicture(problem: Problem): Canvas =
        Canvas(200.0, 200.0).apply {
            with (graphicsContext2D) {
                appendSVGPath(problem.svgPath)
                stroke()
            }
        }

    private fun buildProblemText(problem: Problem): TextArea =
        TextArea(problem.text).apply {
            isEditable = false
            prefRowCount = (problem.text.lineSequence().count())
            maxHeight = Double.NEGATIVE_INFINITY
            maxWidth = Double.NEGATIVE_INFINITY
        }

    private fun buildProblemFields(problem: Problem): Array<VBox> {
        val variablesFields: MutableList<VarField> = mutableListOf()
        val answersFields: MutableList<AnsField> = mutableListOf()
        val submitFun: () -> Unit = { answersFields.submit(variablesFields.validate()) }

        return arrayOf(
            makeVarVBox(VarContext(problem.variables, variablesFields, submitFun)),
            makeAnsVBox(AnsContext(problem.answers, answersFields, submitFun))
        )
    }


    private data class VarField(
        val textField: TextField,
        val comboBox: ComboBox<Factor>,
        val label: Label
    )

    private data class AnsField(
        val textField: TextField,
        val comboBox: ComboBox<Factor>,
        val calcFun: (List<Double>) -> Double
    )

    private data class VarContext(
        val variables: List<Variable<Factor>>,
        val variablesFields: MutableList<VarField>,
        val submitAction: () -> Unit
    )

    private data class AnsContext(
        val answers: List<Answer<Factor>>,
        val answersFields: MutableList<AnsField>,
        val submitAction: () -> Unit
    )


    private fun List<VarField>.validate() : List<Double>? {
        val values = arrayOfNulls<Double>(size)
        for ((i, field) in withIndex()) {
            val (textField, comboBox, label) = field

            val textValue = textField.text.toDoubleOrNull()
            if (textValue == null) {
                label.text = "введите число"
                continue
            } else {
                label.text = ""
            }

            values[i] = textValue * comboBox.value.factor
        }
        return values.requireNoNullsOrNull()?.toList()
    }

    private fun Array<Double?>.requireNoNullsOrNull() : Array<Double>? {
        for (element in this) {
            if (element == null) return null
        }
        @Suppress("UNCHECKED_CAST")
        return this as Array<Double>
    }

    private fun List<AnsField>.submit(vars: List<Double>?) {
        for (field in this) {
            field.textField.text = if (vars != null) (field.calcFun(vars) * field.comboBox.value.factor).toString() else ""
        }
    }


    private fun makeVarVBox(context: VarContext) : VBox {
        val (variables, variablesFields, submitFun) = context

        val varGridPane = makeGridPane(variables.size)

        for ((i, v) in variables.withIndex()) {
            val label = Label(v.label + ":")

            val textField = makeTextField(submitFun)
            val comboBox = makeComboBox(v, submitFun)
            val hBox = HBox(textField, comboBox).apply { alignment = Pos.CENTER }

            val errLabel = Label("").apply { textFill = Color.RED }

            varGridPane.apply {
                add(label, 0, i)
                add(hBox, 1, i)
                add(errLabel, 2, i)
            }

            variablesFields.add(VarField(textField, comboBox, errLabel))
        }

        val submitButton = Button("Мне повезет")
        submitButton.setOnMouseClicked { submitFun() }

        return VBox(20.0).apply {
            alignment = Pos.CENTER
            children.addAll(varGridPane, submitButton)
        }
    }

    private fun makeAnsVBox(context: AnsContext) : VBox {
        val (answers, answersFields, submitFun) = context

        val ansLabel = Label("Ответ")

        val ansGridPane = makeGridPane(answers.size)

        for ((i, a) in answers.withIndex()) {
            val label = Label(a.label + ":")

            val textField = makeTextField(submitFun).apply { isEditable = false }
            val comboBox = makeComboBox(a, submitFun)
            val hBox = HBox(textField, comboBox).apply { alignment = Pos.CENTER }

            ansGridPane.apply {
                add(label, 0, i)
                add(hBox, 1, i)
            }

            answersFields.add(AnsField(textField, comboBox, a::calculate))
        }

        return VBox().apply {
            alignment = Pos.CENTER
            children.addAll(ansLabel, ansGridPane)
        }
    }


    private fun makeGridPane(row: Int = 3, column: Int = 3) : GridPane {
        return GridPane().apply {
            hgap = 10.0
            vgap = 5.0

            rowConstraints.apply {
                for (i in 0 until row) add(RowConstraints(10.0, 30.0, 50.0, Priority.SOMETIMES, VPos.CENTER, false))
            }

            columnConstraints.apply {
                for (i in 0 until column) add(ColumnConstraints(10.0, 100.0, 500.0, Priority.SOMETIMES, HPos.CENTER, true))

                get(0).halignment = HPos.RIGHT
                get(1).prefWidth = 200.0
                get(2).halignment = HPos.LEFT
            }
        }
    }

    private inline fun makeTextField(crossinline submitAction: () -> Unit) : TextField {
        return TextField().apply {
            prefWidth = 300.0
            textProperty().addListener { _, _, _ -> submitAction() }
        }
    }

    private inline fun <reified E: Factor> makeComboBox(variable: Variable<E>, crossinline submitAction: () -> Unit) : ComboBox<E> {
        return ComboBox<E>().apply {
            prefWidth = 200.0
            items.setAll(variable.factors)
            converter = factorConverter<E>()
            value = variable.factors[0]
            valueProperty().addListener { _, _, _ -> submitAction() }
        }
    }

    private inline fun <reified E : Factor> factorConverter() = object : StringConverter<E>() {
        override fun toString(p: E?): String {
            return p ?. label ?: ""
        }
        override fun fromString(p: String?): E {
            throw RuntimeException("Never happened")
        }
    }
}