package components.factors.mechanics.complex

import components.Factor

/*
Ускорение
 */
enum class Acceleration(override val label: String, override val factor: Double) : Factor {
    METRE_PER_SECOND_SQUARED("м/с²", 1e0),
    CENTIMETER_PER_SECOND_SQUARED("cм/с²", 1e-2)
}