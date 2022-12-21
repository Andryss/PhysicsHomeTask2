package components.factors.electromagnetism

import components.Factor

/*
Сопротивление
 */
enum class Resistance(override val label: String, override val factor: Double) : Factor {
    OHM("Ом", 1e0)
}