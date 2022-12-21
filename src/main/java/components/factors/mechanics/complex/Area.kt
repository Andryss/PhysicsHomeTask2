package components.factors.mechanics.complex

import components.Factor

/*
Площадь
 */
enum class Area(override val label: String, override val factor: Double) : Factor {
    SQUARE_METRE("м²", 1e0),
    SQUARE_CENTIMETRE("см²", 1e-4),
    SQUARE_MILLIMETRE("мм²", 1e-6)
}