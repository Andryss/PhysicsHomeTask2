package components.factors.electromagnetism

import components.Factor

enum class Voltage(override val label: String, override val factor: Double) : Factor {
    VOLT("В", 1e0)
}