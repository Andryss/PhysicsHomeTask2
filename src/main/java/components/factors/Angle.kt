package components.factors

import components.Factor
import kotlin.math.PI

/*
Уголочек
 */
enum class Angle(override val label: String, override val factor: Double) : Factor {
    RADIAN("рад", 1e0),
    DEGREE("°", 2 * PI / 360);

    open class Variable : components.Variable<Angle> {
        constructor() { label = "α" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Angle.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Angle> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = object : Variable() {}
    }
}