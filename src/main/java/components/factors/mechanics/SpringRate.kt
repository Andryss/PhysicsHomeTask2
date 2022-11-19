package components.factors.mechanics

import components.Factor

enum class SpringRate(override val label: String, override val factor: Double) : Factor {
    NEWTON_PER_METER("Н/м", 1e0),
    MILLINEWTON_PER_METER("мН/м", 1e-3)
}