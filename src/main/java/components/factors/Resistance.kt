package components.factors

import components.Factor

enum class Resistance(override val label: String, override val factor: Double) : Factor {
    OHM("Ом", 1e0)
}