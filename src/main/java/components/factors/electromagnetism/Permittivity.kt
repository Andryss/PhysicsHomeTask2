package components.factors.electromagnetism

import components.Factor

/*
Диэлектрическая проницаемость среды
 */
enum class Permittivity(override val label: String, override val factor: Double) : Factor {
    NO_VALUE("единицы", 1e0);
}