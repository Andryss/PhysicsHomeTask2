package components.factors.electromagnetism

import components.Factor

/*
Магнитная индукция
 */
enum class MagneticField(override val label: String, override val factor: Double): Factor {
    TESLA("Тл", 1e0)
}