package components.factors.electromagnetism

import components.Factor

/*
Сила тока
 */
enum class ElectricCurrent(override val label: String, override val factor: Double) : Factor {
    AMPERE("А", 1e0);

    open class Variable : components.Variable<ElectricCurrent> {
        constructor() { label = "I" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = ElectricCurrent.values().toList()
    }

    abstract class Answer : Variable, components.Answer<ElectricCurrent> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}