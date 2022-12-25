package problems.lesson10

import components.*
import components.factors.electromagnetism.ElectricCurrent
import components.factors.electromagnetism.complex.ElectricCurrentPerTime
import components.factors.mechanics.complex.Area
import components.factors.mechanics.Length
import components.factors.mechanics.complex.NumberPerLength

@Suppress("unused")
class Problem104 : Problem {
    override val id: Int
        get() = 10

    override val label: String
        get() = "Задача 4"

    override val svgPath: String
        get() = "M 50 70 C 60 70 60 130 50 130 C 40 130 40 70 50 70 H 115 M 105 70 C 105 68 110 60 115 60 C 135 60 135 140 115 140 C 110 140 105 132 105 130 M 115 70 C 125 70 125 130 115 130 M 115 130 H 50 M 126 70 H 150 C 160 70 160 130 150 130 H 126 M 45 121 L 55 79 L 55 85 L 52 84 L 55 79 M 45 121 L 45 115 L 48 116 L 45 121 M 35 90 V 106 C 35 95 28 95 28 102 C 28 108 34 109 35 102 M 50 60 H 80 L 74 63 L 74 57 L 80 60 M 50 60 L 56 63 L 56 57 L 50 60 M 60 29 V 52 M 60 29 L 70 52 V 29 M 65 70 C 75 70 75 130 65 130 M 80 70 C 90 70 90 130 80 130 M 95 70 C 105 70 105 130 95 130 M 110 70 C 120 70 120 130 110 130 M 135 70 C 145 70 145 130 135 130 M 135 30 C 135 27 123 26 123 34 C 123 44 135 35 135 46 C 135 52 123 52 123 49 M 115 70"

    override val text: String
        get() = "На длинный прямой соленоид, имеющий диаметр сечения d и содержащий N \nвитков на один сантиметр длины, плотно надет круговой виток из медного \nпровода сечением S. Найти ток в витке, если ток в обмотке соленоида \nувеличивают с постоянной скоростью ΔI. Индуктивностью витка пренебречь"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            Length.Variable("d"),
            NumberPerLength.simpleVariable,
            Area.simpleVariable,
            ElectricCurrentPerTime.simpleVariable
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : ElectricCurrent.Answer() {
                override fun calculate(vars: List<Double>): Double {
                    val d = vars[0]
                    val N = vars[1]
                    val S = vars[2]
                    val dI = vars[3]
                    return (Constants.mu0 / Constants.copperElectricalResistivity) * 1/4 * d * N * dI * S
                }
            }
        )
}