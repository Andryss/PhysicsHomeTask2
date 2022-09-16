package components.factors

import components.Factor

enum class Number(override val factor: Double, override val label: String) : Factor {
    NO_VALUE(1e0, "единицы")
}