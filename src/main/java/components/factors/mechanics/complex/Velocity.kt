package components.factors.mechanics.complex

import components.Factor

/*
Скорость
 */
enum class Velocity(override val label: String, override val factor: Double) : Factor {
    METER_PER_SECOND("м/с", 1e0);

    open class Variable : components.Variable<Velocity> {
        constructor() { label = "v" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Velocity.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Velocity> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}