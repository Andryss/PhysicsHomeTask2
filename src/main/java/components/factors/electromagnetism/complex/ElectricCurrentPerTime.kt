package components.factors.electromagnetism.complex

import components.Factor

/*
Сила тока в секунду ?
 */
enum class ElectricCurrentPerTime(override val label: String, override val factor: Double) : Factor {
    AMPERE_PER_SECOND("А/с", 1e0)
}