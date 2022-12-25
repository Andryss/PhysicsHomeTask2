package components.factors.electromagnetism

import components.Factor

/*
Диэлектрическая проницаемость среды
 */
enum class Permittivity(override val label: String, override val factor: Double) : Factor {
    NO_VALUE("единицы", 1e0);

    open class Variable : components.Variable<Permittivity> {
        constructor() { label = "ε" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Permittivity.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Permittivity> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}