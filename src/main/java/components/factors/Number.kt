package components.factors

import components.Factor

/*
Чиселка
 */
enum class Number(override val factor: Double, override val label: String) : Factor {
    NO_VALUE(1e0, "единицы");

    open class Variable : components.Variable<Number> {
        constructor() { label = "N" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Number.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Number> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}