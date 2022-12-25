package components.factors

import components.Factor

/*
Времечко
 */
enum class Time(override val label: String, override val factor: Double) : Factor {
    SECOND("с", 1e0),
    MINUTE("мин", 1.0/60);

    open class Variable : components.Variable<Time> {
        constructor() { label = "t" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Time.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Time> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = object : Variable() {}
    }
}