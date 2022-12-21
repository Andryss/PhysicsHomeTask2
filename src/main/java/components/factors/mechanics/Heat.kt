package components.factors.mechanics

import components.Factor

/*
Количество тепла
 */
enum class Heat(override val label: String, override val factor: Double) : Factor {
    JOULE("Дж", 1e0)
}