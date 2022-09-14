enum class LinearChargeDensity(override val factor: Double, override val label: String) : Value {
    COULOMB_PER_METER(1e0, "Кл/м"),
    MILLICOULOMB_PER_METER(1e-3, "мКл/м"),
    MICROCOULOMB_PER_METER(1e-6, "мкКл/м")
}