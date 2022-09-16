package components.factors

import components.Factor

enum class Length(override val factor: Double, override val label: String) : Factor {
    KILOMETERS(1e3, "км"),
    METERS(1e0, "м"),
    CENTIMETERS(1e-2, "см"),
    MILLIMETERS(1e-3, "мм")
}