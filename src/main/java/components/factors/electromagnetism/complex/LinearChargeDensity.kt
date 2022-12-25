package components.factors.electromagnetism.complex

import components.Factor

/*
Линейная плотность заряда
 */
enum class LinearChargeDensity(override val factor: Double, override val label: String) : Factor {
    COULOMB_PER_METER(1e0, "Кл/м"),
    MILLICOULOMB_PER_METER(1e-3, "мКл/м"),
    MICROCOULOMB_PER_METER(1e-6, "мкКл/м");

    open class Variable : components.Variable<LinearChargeDensity> {
        constructor() { label = "λ" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = LinearChargeDensity.values().toList()
    }

    abstract class Answer : Variable, components.Answer<LinearChargeDensity> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}