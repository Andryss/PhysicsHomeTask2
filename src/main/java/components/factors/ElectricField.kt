package components.factors

import components.Factor

enum class ElectricField(override val factor: Double, override val label: String) : Factor {
    VOLT_PER_METER(1e0, "В/м")
}