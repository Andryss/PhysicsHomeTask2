package components.factors.electromagnetism.complex

import components.Factor

/*
Объемная плотность заряда
 */
enum class VolumeChargeDensity(override val label: String, override val factor: Double) : Factor {
    COULOMB_PER_CUBIC_METER("Кл/м³", 1e0),
    MILLICOULOMB_PER_CUBIC_METER("мКл/м³", 1e-3);

    open class Variable : components.Variable<VolumeChargeDensity> {
        constructor() { label = "ρ" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = VolumeChargeDensity.values().toList()
    }

    abstract class Answer : Variable, components.Answer<VolumeChargeDensity> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}