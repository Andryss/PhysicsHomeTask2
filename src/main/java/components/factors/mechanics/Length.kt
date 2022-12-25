package components.factors.mechanics

import components.Factor

/*
Длина
 */
enum class Length(override val factor: Double, override val label: String) : Factor {
    METERS(1e0, "м"),
    CENTIMETERS(1e-2, "см"),
    MILLIMETERS(1e-3, "мм");

    open class Variable : components.Variable<Length> {
        constructor() { label = "L" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Length.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Length> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = object : Variable() {}
    }
}