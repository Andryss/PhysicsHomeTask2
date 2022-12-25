package components.factors.mechanics.complex

import components.Factor

/*
Количество на длину ?
 */
enum class NumberPerLength(override val label: String, override val factor: Double) : Factor {
    NO_VALUE_PER_METRE("1/м", 1e0),
    NO_VALUE_PER_CENTIMETRE("1/см", 1e2);

    open class Variable : components.Variable<NumberPerLength> {
        constructor() { label = "N" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = NumberPerLength.values().toList()
    }

    abstract class Answer : Variable, components.Answer<NumberPerLength> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = object : Variable() {}
    }
}