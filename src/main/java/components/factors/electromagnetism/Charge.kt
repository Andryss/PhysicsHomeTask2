package components.factors.electromagnetism

import components.Factor

/*
Заряд
 */
enum class Charge(override val factor: Double, override val label: String) : Factor {
    COULOMB(1e0, "Кл"),
    MILLICOULOMB(1e-3, "мКл");

    open class Variable : components.Variable<Charge> {
        constructor() { label = "q" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Charge.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Charge> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}