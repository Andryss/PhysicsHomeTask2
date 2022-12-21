package components.factors.mechanics

import components.Factor

/*
Длина
 */
enum class Length(override val factor: Double, override val label: String) : Factor {
    METERS(1e0, "м"),
    CENTIMETERS(1e-2, "см"),
    MILLIMETERS(1e-3, "мм")
}