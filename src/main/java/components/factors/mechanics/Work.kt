package components.factors.mechanics

import components.Factor

enum class Work(override val label: String, override val factor: Double) : Factor {
    JOULE("Дж", 1e0)
}