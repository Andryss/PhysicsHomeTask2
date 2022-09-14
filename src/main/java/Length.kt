enum class Length(override val factor: Double, override val label: String) : Value {
    KILOMETERS(1e3, "км"),
    METERS(1e0, "м"),
    CENTIMETERS(1e-2, "см"),
    MILLIMETERS(1e-3, "мм")
}