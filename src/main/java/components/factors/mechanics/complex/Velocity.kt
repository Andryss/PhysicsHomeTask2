package components.factors.mechanics.complex

import components.Factor

/*
Скорость
 */
enum class Velocity(override val label: String, override val factor: Double) : Factor {
    METER_PER_SECOND("м/с", 1e0)
}