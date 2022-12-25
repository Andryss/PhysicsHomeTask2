package components.factors.electromagnetism.complex

import components.Factor

/*
Электрическая индукция D
 */
enum class ElectricDisplacementField(override val label: String, override val factor: Double) : Factor {
    COULOMB_PER_METER_SQUARE("Кл/м²", 1e0);

    open class Variable : components.Variable<ElectricDisplacementField> {
        constructor() { label = "D" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = ElectricDisplacementField.values().toList()
    }

    abstract class Answer : Variable, components.Answer<ElectricDisplacementField> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}