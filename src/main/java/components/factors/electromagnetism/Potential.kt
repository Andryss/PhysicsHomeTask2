package components.factors.electromagnetism

import components.Factor

/*
Потенциал
 */
enum class Potential(override val factor: Double, override val label: String) : Factor {
    VOLT(1e0, "В");

    open class Variable : components.Variable<Potential> {
        constructor() { label = "φ" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Potential.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Potential> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}