package components.factors.mechanics

import components.Factor

/*
Масса
 */
enum class Mass(override val label: String, override val factor: Double) : Factor {
    KILOGRAM("Кг", 1e0),
    MILLIGRAM("мг", 1e-3)
}