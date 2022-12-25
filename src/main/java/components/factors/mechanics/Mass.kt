package components.factors.mechanics

import components.Factor

/*
Масса
 */
enum class Mass(override val label: String, override val factor: Double) : Factor {
    KILOGRAM("Кг", 1e0),
    MILLIGRAM("мг", 1e-3);

    open class Variable : components.Variable<Mass> {
        constructor() { label = "m" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Mass.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Mass> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}