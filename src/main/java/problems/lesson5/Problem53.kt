package problems.lesson5

import components.Answer
import components.Factor
import components.Problem
import components.Variable
import components.factors.Angle
import components.factors.ElectricField
import components.factors.Permittivity
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

@Suppress("unused")
class Problem53 : Problem {
    override val id: Int
        get() = 5

    override val label: String
        get() = "Задача 3"

    override val svgPath: String
        get() = ""

    override val text: String
        get() = "Тонкая пластина из диэлектрика с Диэлектрической проницаемостью ε помещена \nв однородное электрическое поле так, что нормаль к ее поверхности составляет \nугол α с напряженностью E₀. Найти напряженность электрического поля внутри \nдиэлектрика"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            object : Variable<Permittivity> {
                override val label: String
                    get() = "ε"
                override val factors: List<Permittivity>
                    get() = Permittivity.values().toList()
            },
            object : Variable<Angle> {
                override val label: String
                    get() = "α"
                override val factors: List<Angle>
                    get() = Angle.values().toList()
            },
            object : Variable<ElectricField> {
                override val label: String
                    get() = "E₀"
                override val factors: List<ElectricField>
                    get() = ElectricField.values().toList()
            }
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Answer<ElectricField> {
                override val label: String
                    get() = "E"
                override val factors: List<ElectricField>
                    get() = ElectricField.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    (vars[2] / vars[0] * sqrt(cos(vars[1]) * cos(vars[1]) + vars[0] * vars[0] * sin(vars[1]) * sin(vars[1])))
            }
        )
}