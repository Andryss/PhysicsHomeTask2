package components.factors

import components.Factor

enum class ElectricDisplacementField(override val label: String, override val factor: Double) : Factor {
    COULOMB_PER_METER_SQUARE("Кл/м²", 1e0)
}