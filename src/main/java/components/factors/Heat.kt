package components.factors

import components.Factor

enum class Heat(override val label: String, override val factor: Double) : Factor {
    JOULE("Дж", 1e0)
}