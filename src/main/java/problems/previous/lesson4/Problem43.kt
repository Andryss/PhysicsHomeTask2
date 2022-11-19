package problems.previous.lesson4

import components.*
import components.factors.electromagnetism.Charge
import components.factors.mechanics.Length
import components.factors.electromagnetism.Potential

@Suppress("unused")
class Problem43 : Problem {
    override val id: Int
        get() = 4

    override val label: String
        get() = "Задача 3"

    override val svgPath: String
        get() = "M 20 100 A 1 1 0 0 0 180 100 A 1 1 0 0 0 20 100 M 100 20 M 100 100 L 157 46 L 154 53 L 150 49 L 157 46 M 150 80 V 60 C 161 60 161 70 150 70 L 159 80 M 60 100 A 1 1 0 0 0 140 100 A 1 1 0 0 0 60 100 M 100 60 M 102 100 A 1 1 0 0 0 98 100 A 1 1 0 0 0 102 100 M 100 100 L 125 130 L 123 122 L 118 127 L 125 130 M 105 120 L 105 135 C 105 111 115 122 115 125 M 70 40 C 70 32 60 32 60 40 C 60 48 70 47 70 37 C 65 60 70 60 73 53"

    override val text: String
        get() = "Заряд q распределен равномерно по объему шара радиуса R. Полагая \nдиэлектрическую проницаемость всюду равной единице, найти потенциал:\nа) в центре шара;\nб) внутри шара как функцию расстояния r от его центра."

    override val variables: List<Variable<Factor>>
        get() = listOf(
            object : Variable<Charge> {
                override val label: String
                    get() = "q"
                override val factors: List<Charge>
                    get() = Charge.values().toList()
            },
            object : Variable<Length> {
                override val label: String
                    get() = "R"
                override val factors: List<Length>
                    get() = Length.values().toList()
            },
            object : Variable<Length> {
                override val label: String
                    get() = "б) r"
                override val factors: List<Length>
                    get() = Length.values().toList()
            }
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Answer<Potential> {
                override val label: String
                    get() = "а) φ"
                override val factors: List<Potential>
                    get() = Potential.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    ((3 * Constants.k * vars[0]) / (2 * vars[1]))
            },
            object : Answer<Potential> {
                override val label: String
                    get() = "б) φ"
                override val factors: List<Potential>
                    get() = Potential.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    (((3 * Constants.k * vars[0]) / (2 * vars[1])) * (1 - (vars[2] * vars[2]) / (3 * vars[1] * vars[1])))
            }
        )
}