package problems.lesson4

import components.*
import components.factors.Charge
import components.factors.Length
import components.factors.SpringRate
import kotlin.math.PI
import kotlin.math.sqrt

@Suppress("unused")
class Problem47 : Problem {
    override val id: Int
        get() = 4

    override val label: String
        get() = "Задача 7"

    override val svgPath: String
        get() = ""

    override val text: String
        get() = "Небольшой шарик висит над горизонтальной безграничной проводящей \nплоскостью на изолирующей упругой нити жесткости k. После того как шарик \nзарядили, он опустился на x см, и его расстояние до проводящей плоскости \nстало равным l. Найти заряд шарика."

    override val variables: List<Variable<Factor>>
        get() = listOf(
            object : Variable<SpringRate> {
                override val label: String
                    get() = "k"
                override val factors: List<SpringRate>
                    get() = SpringRate.values().toList()
            },
            object : Variable<Length> {
                override val label: String
                    get() = "x"
                override val factors: List<Length>
                    get() = Length.values().toList()
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
            object : Answer<Charge> {
                override val label: String
                    get() = "q"
                override val factors: List<Charge>
                    get() = Charge.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    (4 * vars[2] * sqrt(PI * Constants.e0 * vars[0] * vars[1]))
            }
        )
}