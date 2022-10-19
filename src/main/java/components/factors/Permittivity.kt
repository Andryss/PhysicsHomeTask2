package components.factors

import components.Factor

enum class Permittivity(override val label: String, override val factor: Double) : Factor {
    FARAD_PER_METER("Ф/м", 1e0);
}