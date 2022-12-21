package components.factors

import components.Factor

/*
Времечко
 */
enum class Time(override val label: String, override val factor: Double) : Factor {
    SECOND("с", 1e0),
    MINUTE("мин", 1.0/60)
}