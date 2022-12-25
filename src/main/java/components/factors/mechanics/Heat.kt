package components.factors.mechanics

import components.Factor

/*
Количество тепла
 */
enum class Heat(override val label: String, override val factor: Double) : Factor {
    JOULE("Дж", 1e0);

    open class Variable : components.Variable<Heat> {
        constructor() { label = "Q" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Heat.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Heat> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = object : Variable() {}
    }
}