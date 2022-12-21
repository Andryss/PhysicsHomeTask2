package components.factors.electromagnetism.complex

import components.Factor

/*
Магнитная индукция в секунду ?
 */
enum class MagneticFieldPerTime(override val label: String, override val factor: Double) : Factor {
    TESLA_PER_SECOND("Тл/с", 1e0)
}