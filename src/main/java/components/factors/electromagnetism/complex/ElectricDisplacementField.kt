package components.factors.electromagnetism.complex

import components.Factor

/*
Электрическая индукция D
 */
enum class ElectricDisplacementField(override val label: String, override val factor: Double) : Factor {
    COULOMB_PER_METER_SQUARE("Кл/м²", 1e0)
}