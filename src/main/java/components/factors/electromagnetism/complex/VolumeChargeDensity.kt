package components.factors.electromagnetism.complex

import components.Factor

/*
Объемная плотность заряда
 */
enum class VolumeChargeDensity(override val label: String, override val factor: Double) : Factor {
    COULOMB_PER_CUBIC_METER("Кл/м³", 1e0),
    MILLICOULOMB_PER_CUBIC_METER("мКл/м³", 1e-3)
}