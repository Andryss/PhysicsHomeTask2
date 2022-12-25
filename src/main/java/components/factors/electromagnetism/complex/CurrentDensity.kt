package components.factors.electromagnetism.complex

import components.Factor

/*
Плотность тока
 */
enum class CurrentDensity(override val factor: Double, override val label: String) : Factor {
    AMPERE_PER_SQUARE_METER(1e0, "А/м²");

    open class Variable : components.Variable<CurrentDensity> {
        constructor() { label = "j" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = CurrentDensity.values().toList()
    }

    abstract class Answer : Variable, components.Answer<CurrentDensity> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}