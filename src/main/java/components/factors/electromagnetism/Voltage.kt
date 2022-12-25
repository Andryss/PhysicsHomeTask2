package components.factors.electromagnetism

import components.Factor

/*
Напряжение
 */
enum class Voltage(override val label: String, override val factor: Double) : Factor {
    VOLT("В", 1e0);

    open class Variable : components.Variable<Voltage> {
        constructor() { label = "U" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Voltage.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Voltage> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}