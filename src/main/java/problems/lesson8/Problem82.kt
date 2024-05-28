package problems.lesson8

import components.*
import components.factors.electromagnetism.ElectricCurrent
import components.factors.electromagnetism.MagneticField
import components.factors.electromagnetism.Permeability
import components.factors.mechanics.Length

@Suppress("unused")
class Problem82 : Problem {
    override val id: Int
        get() = 8

    override val label: String
        get() = "Задача 2(б)"

    override val svgPath: String
        get() = "M 30 100 C 30 79 170 79 170 100 C 170 122 30 123 30 100 M 100 100 V 48 L 100 100 M 100 100 L 124 116 L 120 109 L 116 114 L 124 116 M 131 142 V 120 C 145 120 144 131 131 131 L 142 142 M 107 56 C 115 51 115 76 107 72 M 119 56 C 111 51 111 76 119 72 M 86 22 C 74 22 74 48 86 48 C 98 48 98 22 86 22 M 100 50 A 1 1 0 0 0 100 46 A 1 1 0 0 0 100 50 M 46 121 C 56 124 68 126 79 126 L 70 122 L 70 129 L 79 126 M 49 131 H 63 M 56 131 V 154 M 49 154 H 63"

    override val text: String
        get() = "Найти магнитное поле кругового тока радиуса R на оси витка в точке, \nотстоящей от его центра на x.\n"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            object : Variable<ElectricCurrent> {
                override val label: String
                    get() = "I"
                override val factors: List<ElectricCurrent>
                    get() = ElectricCurrent.values().toList()
            },
            Length.Variable("R"),
            Length.Variable("x"),
            Permeability.simpleVariable
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : MagneticField.Answer() {
                override fun calculate(vars: List<Double>): Double {
                    val I = vars[0]
                    val R = vars[1].coerceAtLeast(1e-10)
                    val x = vars[2].coerceAtLeast(1e-10)
                    val mu = vars[3]
                    return (mu * Constants.mu0 * I * R) / (2 * (R * R + x * x))
                }
            }
        )
}