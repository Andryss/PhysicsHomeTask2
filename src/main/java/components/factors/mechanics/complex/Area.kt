package components.factors.mechanics.complex

import components.Factor

/*
Площадь
 */
enum class Area(override val label: String, override val factor: Double) : Factor {
    SQUARE_METRE("м²", 1e0),
    SQUARE_CENTIMETRE("см²", 1e-4),
    SQUARE_MILLIMETRE("мм²", 1e-6);

    open class Variable : components.Variable<Area> {
        constructor() { label = "S" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Area.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Area> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = object : Variable() {}
    }
}