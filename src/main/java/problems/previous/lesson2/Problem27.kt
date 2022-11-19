package problems.previous.lesson2

import components.Constants
import components.*
import components.factors.electromagnetism.Charge
import components.factors.mechanics.Length
import components.factors.Number

@Suppress("unused")
class Problem27 : Problem {
    override val id: Int
        get() = 2

    override val label: String
        get() = "Задача 7"

    override val svgPath: String
        get() = "M 100 0 V 200 M 20 100 A 1 1 0 0 0 180 100 A 1 1 0 0 0 20 100 M 100 100 L 51 37 L 54 45 L 58 42 L 51 37 M 46 68 V 54 C 54 54 54 62 46 62 L 52 68 M 115 121 C 122 121 122 107 115 107 C 107 107 107 121 115 121 C 116 124 118 124 120 122"

    override val text: String
        get() = "Имеется аксиально-симметричное электрическое поле, напряженность которого \nзависит от расстояния r до его оси как E=a/r , где a — постоянная. \nНайти заряд внутри сферы радиуса R с центром на оси этого поля"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            object : Variable<Length> {
                override val label: String
                    get() = "R"
                override val factors: List<Length>
                    get() = Length.values().toList()
            },
            object : Variable<Number> {
                override val label: String
                    get() = "a"
                override val factors: List<Number>
                    get() = Number.values().toList()

            }
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Answer<Charge> {
                override val label: String
                    get() = "Q"
                override val factors: List<Charge>
                    get() = Charge.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    ((vars[0] * vars[1]) / Constants.k)
            }
        )
}