package components.factors.electromagnetism

import components.Factor

/*
Электродвижущая сила (ЭДС)
 */
enum class ElectromotiveForce(override val label: String, override val factor: Double) : Factor {
    VOLT("В", 1e0);

    open class Variable : components.Variable<ElectromotiveForce> {
        constructor() { label = "ε" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = ElectromotiveForce.values().toList()
    }

    abstract class Answer : Variable, components.Answer<ElectromotiveForce> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}