package components.factors

import components.Factor

enum class Capacitance(override val label: String, override val factor: Double) : Factor {
    FARAD("Ф", 1e0),
    MILLIFARAD("мФ", 1e-3),
    MICROFARAD("мкФ", 1e-6)
}