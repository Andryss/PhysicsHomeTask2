package components.factors.mechanics

import components.Factor

/*
Работа
 */
enum class Work(override val label: String, override val factor: Double) : Factor {
    JOULE("Дж", 1e0)
}