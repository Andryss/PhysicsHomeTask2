package components.factors.mechanics.complex

import components.Factor

/*
Коэффициент жесткости пружины
 */
enum class SpringRate(override val label: String, override val factor: Double) : Factor {
    NEWTON_PER_METER("Н/м", 1e0),
    MILLINEWTON_PER_METER("мН/м", 1e-3);

    open class Variable : components.Variable<SpringRate> {
        constructor() { label = "k" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = SpringRate.values().toList()
    }

    abstract class Answer : Variable, components.Answer<SpringRate> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}