package components.factors.electromagnetism

import components.Factor

/*
Электродвижущая сила (ЭДС)
 */
enum class ElectromotiveForce(override val label: String, override val factor: Double) : Factor {
    VOLT("В", 1e0)
}