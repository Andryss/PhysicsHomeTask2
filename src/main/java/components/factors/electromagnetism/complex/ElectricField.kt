package components.factors.electromagnetism.complex

import components.Factor

/*
Напряженность
 */
enum class ElectricField(override val factor: Double, override val label: String) : Factor {
    VOLT_PER_METER(1e0, "В/м");

    open class Variable : components.Variable<ElectricField> {
        constructor() { label = "E" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = ElectricField.values().toList()
    }

    abstract class Answer : Variable, components.Answer<ElectricField> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}