package components.factors.electromagnetism

import components.Factor

enum class ElectricCurrent(override val label: String, override val factor: Double) : Factor {
    AMPERE("А", 1e0)
}