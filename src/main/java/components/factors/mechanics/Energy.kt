package components.factors.mechanics

import components.Factor

/*
Энергия
 */
enum class Energy(override val label: String, override val factor: Double) : Factor {
    JOULE("Дж", 1e0)
}