package problems.previous.lesson4

import components.*
import components.factors.electromagnetism.Charge
import components.factors.mechanics.Length
import components.factors.mechanics.complex.SpringRate
import kotlin.math.PI
import kotlin.math.sqrt

@Suppress("unused")
class Problem47 : Problem {
    override val id: Int
        get() = 4

    override val label: String
        get() = "Задача 7"

    override val svgPath: String
        get() = "M 10 110 L 20 90 H 190 L 180 110 H 10 M 100 100 V 70 A 1 1 0 0 0 100 40 A 1 1 0 0 0 100 70 M 143 80 C 155 67 151 57 148 67 C 142 85 148 92 150 84 M 130 100 V 70 L 128 78 L 132 78 L 130 70 M 130 100 L 128 92 L 132 92 L 130 100 M 130 70 L 132 62 L 128 62 L 130 70 V 45 L 128 53 L 132 53 L 130 45 M 141 40 C 148 35 150 60 141 55 M 153 40 C 146 35 145 60 153 55 M 71 61 V 87 M 71 78 L 81 69 M 71 78 L 82 87"

    override val text: String
        get() = "Небольшой шарик висит над горизонтальной безграничной проводящей \nплоскостью на изолирующей упругой нити жесткости k. После того как шарик \nзарядили, он опустился на x см, и его расстояние до проводящей плоскости \nстало равным l. Найти заряд шарика."

    override val variables: List<Variable<Factor>>
        get() = listOf(
            SpringRate.simpleVariable,
            Length.Variable("x"),
            Length.Variable("l")
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Charge.Answer() {
                override fun calculate(vars: List<Double>): Double =
                    (4 * vars[2] * sqrt(PI * Constants.e0 * vars[0] * vars[1]))
            }
        )
}