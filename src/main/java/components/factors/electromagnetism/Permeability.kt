package components.factors.electromagnetism

import components.Factor

/*
Магнитная проницаемость среды
 */
enum class Permeability(override val label: String, override val factor: Double): Factor {
    NO_VALUE("единицы", 1e0)
}