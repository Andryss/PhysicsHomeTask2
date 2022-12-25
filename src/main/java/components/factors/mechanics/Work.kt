package components.factors.mechanics

import components.Factor

/*
Работа
 */
enum class Work(override val label: String, override val factor: Double) : Factor {
    JOULE("Дж", 1e0);

    open class Variable : components.Variable<Work> {
        constructor() { label = "A" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Work.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Work> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = object : Variable() {}
    }
}