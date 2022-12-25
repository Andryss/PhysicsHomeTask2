package components.factors.electromagnetism

import components.Factor

/*
Магнитная проницаемость среды
 */
enum class Permeability(override val label: String, override val factor: Double): Factor {
    NO_VALUE("единицы", 1e0);

    open class Variable : components.Variable<Permeability> {
        constructor() { label = "μ" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Permeability.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Permeability> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}