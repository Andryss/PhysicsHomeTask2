package problems.lesson4

import components.*
import components.factors.electromagnetism.Charge
import components.factors.mechanics.Length
import components.factors.mechanics.Work

@Suppress("unused")
class Problem48 : Problem {
    override val id: Int
        get() = 4

    override val label: String
        get() = "Задача 8"

    override val svgPath: String
        get() = "M 50 20 L 70 10 V 180 L 50 190 V 20 M 60 100 H 150 M 153 100 A 1 1 0 0 0 147 100 A 1 1 0 0 0 153 100 M 103 88 C 114 67 109 63 105 74 C 101 87 105 103 111 93 M 155 120 C 155 111 145 111 145 120 C 145 128 155 126 155 116 C 150 136 152 141 157 134 M 160 100 H 165 M 175 100 H 180"

    override val text: String
        get() = "Точечный заряд q находится на расстоянии l от безграничной проводящей \nплоскости. Какую работу необходимо совершить, чтобы медленно удалить этот \nзаряд на очень большое расстояние от плоскости?"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            Charge.simpleVariable,
            Length.Variable("l")
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Work.Answer() {
                override fun calculate(vars: List<Double>): Double =
                    ((Constants.k * vars[0] * vars[0]) / (4 * vars[1]))
            }
        )
}