package components.factors.mechanics.complex

import components.Factor

/*
Ускорение
 */
enum class Acceleration(override val label: String, override val factor: Double) : Factor {
    METRE_PER_SECOND_SQUARED("м/с²", 1e0),
    CENTIMETER_PER_SECOND_SQUARED("cм/с²", 1e-2);

    open class Variable : components.Variable<Acceleration> {
        constructor() { label = "a" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Acceleration.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Acceleration> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = object : Variable() {}
    }
}