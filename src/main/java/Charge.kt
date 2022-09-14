enum class Charge(override val factor: Double, override val label: String) : Value {
    COULOMB(1e0, "Кл"),
    MILLICOULOMB(1e-3, "мКл")
}