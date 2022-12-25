package components.factors.mechanics

import components.Factor

/*
Энергия
 */
enum class Energy(override val label: String, override val factor: Double) : Factor {
    JOULE("Дж", 1e0);

    open class Variable : components.Variable<Energy> {
        constructor() { label = "W" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Energy.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Energy> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}