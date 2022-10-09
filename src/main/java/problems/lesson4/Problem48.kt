package problems.lesson4

import components.*
import components.factors.Charge
import components.factors.Length
import components.factors.Work

@Suppress("unused")
class Problem48 : Problem {
    override val id: Int
        get() = 4

    override val label: String
        get() = "Задача 8"

    override val svgPath: String
        get() = ""

    override val text: String
        get() = "Точечный заряд q находится на расстоянии l от безграничной проводящей \nплоскости. Какую работу необходимо совершить, чтобы медленно удалить этот \nзаряд на очень большое расстояние от плоскости?"

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
                    get() = "l"
                override val factors: List<Length>
                    get() = Length.values().toList()
            }
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Answer<Work> {
                override val label: String
                    get() = "A"
                override val factors: List<Work>
                    get() = Work.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    ((Constants.k * vars[0] * vars[0]) / (4 * vars[1]))
            }
        )
}