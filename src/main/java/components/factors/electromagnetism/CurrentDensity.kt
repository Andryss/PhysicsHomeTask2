package components.factors.electromagnetism

import components.Factor

/*
Плотность тока
 */
enum class CurrentDensity(override val factor: Double, override val label: String) : Factor {
    AMPERE_PER_SQUARE_METER(1e0, "А/м²")
}