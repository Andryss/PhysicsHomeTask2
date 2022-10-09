package problems.lesson4

import components.*
import components.factors.Charge
import components.factors.Length
import components.factors.Potential

@Suppress("unused")
class Problem43 : Problem {
    override val id: Int
        get() = 4

    override val label: String
        get() = "Задача 3"

    override val svgPath: String
        get() = ""

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