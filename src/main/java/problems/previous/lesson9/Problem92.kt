package problems.previous.lesson9

import components.*
import components.factors.electromagnetism.complex.CurrentDensity
import components.factors.electromagnetism.MagneticField
import components.factors.mechanics.Length

@Suppress("unused")
class Problem92 : Problem {
    override val id: Int
        get() = 9

    override val label: String
        get() = "Задача 2"

    override val svgPath: String
        get() = "M 40 100 A 1 1 0 0 0 160 100 A 1 1 0 0 0 40 100 M 60 100 A 1 1 0 0 0 140 100 A 1 1 0 0 0 60 100 M 101 100 A 1 1 0 0 0 99 100 A 1 1 0 0 0 101 100 M 20 100 A 1 1 0 0 0 180 100 A 1 1 0 0 0 20 100 M 39 100 A 1 1 0 0 0 161 100 A 1 1 0 0 0 39 100 M 100 100 L 149 66 L 145 73 L 141 67 L 149 66 M 105 85 V 65 C 119 65 118 75 105 75 L 115 85 M 100 100 L 72 175 L 78 168 L 73 166 L 72 175 M 97 122 V 135 C 97 122 101 120 107 122 M 102 132 H 108 M 105 132 V 138 M 102 138 H 108 M 100 100 L 62 111 L 70 112 L 69 106 L 62 111 M 75 87 V 102 C 75 87 80 84 87 87 M 81 96 H 88 M 83 96 V 103 M 81 103 H 88 M 86 96 V 103 M 39 100 A 1 1 0 0 0 160 100 A 1 1 0 0 0 39 100 A 1 1 0 0 0 161 100 A 1 1 0 0 0 40 100 A 1 1 0 0 0 160 100 M 100 160 A 1 1 0 0 0 100 40 A 1 1 0 0 0 100 161 A 1 1 0 0 0 100 40 A 1 1 0 0 0 100 39 A 1 1 0 0 0 100 160 A 1 1 0 0 0 100 39"

    override val text: String
        get() = "По круглому однородному прямому проводу, радиус сечения которого R, течет \nпостоянный ток плотности j. Найти вектор индукции магнитного поля этого \nтока в точке, положение которой относительно оси провода определяется \nрадиус-вектором r. Магнитную проницаемость всюду считать равной единице. \nПостроить график зависимости B(r)"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            Length.Variable("R"),
            CurrentDensity.simpleVariable,
            Length.Variable("r")
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : MagneticField.Answer() {
                override fun calculate(vars: List<Double>): Double {
                    val R = vars[0]
                    val j = vars[1]
                    val r = vars[2]
                    return if (r <= R) {
                        (Constants.mu0 * j * r) / 2
                    } else {
                        (Constants.mu0 * j * R * R) / (2 * r)
                    }
                }
            }
        )
}