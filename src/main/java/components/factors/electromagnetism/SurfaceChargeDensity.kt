package components.factors.electromagnetism

import components.Factor

enum class SurfaceChargeDensity(override val factor: Double, override val label: String) : Factor {
    COULOMBS_PER_SQUARE_METER(1e0, "К/м²"),
    MILLICOULOMB_PER_SQUARE_METER(1e-3, "мК/м²")
}