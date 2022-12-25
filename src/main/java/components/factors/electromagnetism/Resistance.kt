package components.factors.electromagnetism

import components.Factor

/*
Сопротивление
 */
enum class Resistance(override val label: String, override val factor: Double) : Factor {
    OHM("Ом", 1e0);

    open class Variable : components.Variable<Resistance> {
        constructor() { label = "R" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Resistance.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Resistance> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}