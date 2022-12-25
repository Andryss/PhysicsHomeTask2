package problems.previous.lesson8

import components.*
import components.factors.electromagnetism.ElectricCurrent
import components.factors.electromagnetism.MagneticField
import components.factors.electromagnetism.Permeability
import components.factors.mechanics.Length
import kotlin.math.PI

@Suppress("unused")
class Problem85 : Problem {
    override val id: Int
        get() = 8

    override val label: String
        get() = "Задача 5"

    override val svgPath: String
        get() = "M 40 100 A 1 1 0 0 0 160 100 M 155 100 H 145 M 135 100 H 125 M 115 100 H 105 M 95 100 H 85 M 75 100 H 65 M 55 100 H 45 M 101 100 A 1 1 0 0 0 99 100 A 1 1 0 0 0 101 100 M 100 100 L 64 148 L 71 144 L 66 140 L 64 148 M 60 130 V 110 C 72 110 72 120 60 120 L 69 130 M 103 93 C 95 93 95 75 103 75 C 111 75 111 93 103 93 M 125 157 L 133 148 M 125 148 L 133 157 M 140 155 H 150 M 145 155 V 175 M 140 175 H 150"

    override val text: String
        get() = "Ток I течет по длинному прямому проводнику, сечение которого имеет \nформу тонкого полукольца радиуса R (рисунок). Найти индукцию магнитного \nполя в точке О."

    override val variables: List<Variable<Factor>>
        get() = listOf(
            ElectricCurrent.simpleVariable,
            Length.Variable("R"),
            Permeability.simpleVariable
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : MagneticField.Answer() {
                override fun calculate(vars: List<Double>): Double {
                    val I = vars[0]
                    val R = vars[1].coerceAtLeast(1e-10)
                    val mu = vars[2]
                    return (mu * Constants.mu0 * I) / (PI * PI * R)
                }
            }
        )
}