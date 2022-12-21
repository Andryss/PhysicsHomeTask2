package components.factors.electromagnetism

import components.Factor

/*
Заряд
 */
enum class Charge(override val factor: Double, override val label: String) : Factor {
    COULOMB(1e0, "Кл"),
    MILLICOULOMB(1e-3, "мКл")
}