package components.factors.mechanics.complex

import components.Factor

/*
Количество на длину ?
 */
enum class NumberPerLength(override val label: String, override val factor: Double) : Factor {
    NO_VALUE_PER_METRE("1/м", 1e0),
    NO_VALUE_PER_CENTIMETRE("1/см", 1e2)
}