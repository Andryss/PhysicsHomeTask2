package components.factors.electromagnetism

import components.Factor

enum class Potential(override val factor: Double, override val label: String) : Factor {
    VOLT(1e0, "В")
}