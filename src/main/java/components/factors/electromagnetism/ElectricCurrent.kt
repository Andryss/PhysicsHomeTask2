package components.factors.electromagnetism

import components.Factor
import components.Variable
import components.factors.electromagnetism.complex.ElectricField

/*
Сила тока
 */
enum class ElectricCurrent(override val label: String, override val factor: Double) : Factor {
    AMPERE("А", 1e0);

    companion object {
        val simpleImpl : Variable<ElectricField> = object : Variable<ElectricField> {
            override val label: String
                get() = "I"
            override val factors: List<ElectricField>
                get() = ElectricField.values().toList()
        }
    }
}