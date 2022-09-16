package components.factors

import components.Factor

enum class Charge(override val factor: Double, override val label: String) : Factor {
    COULOMB(1e0, "Кл"),
    MILLICOULOMB(1e-3, "мКл")
}