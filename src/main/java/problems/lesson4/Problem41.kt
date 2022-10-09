package problems.lesson4

import components.*
import components.factors.Charge
import components.factors.Length
import components.factors.Mass
import components.factors.Velocity
import kotlin.math.sqrt

@Suppress("unused")
class Problem41 : Problem {
    override val id: Int
        get() = 4

    override val label: String
        get() = "Задача 1"

    override val svgPath: String
        get() = ""

    override val text: String
        get() = "В точках A и В на расстоянии АВ=l закреплены заряды +9q и -q. \nВдоль прямой AB к ним движется частица массы m, имеющая заряд +q. \nКакую наименьшую скорость должна иметь эта частица на очень большом \nрасстоянии, чтобы достичь точки В?"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            object : Variable<Length> {
                override val label: String
                    get() = "l"
                override val factors: List<Length>
                    get() = Length.values().toList()
            },
            object : Variable<Charge> {
                override val label: String
                    get() = "q"
                override val factors: List<Charge>
                    get() = Charge.values().toList()
            },
            object : Variable<Mass> {
                override val label: String
                    get() = "m"
                override val factors: List<Mass>
                    get() = Mass.values().toList()
            }
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Answer<Velocity> {
                override val label: String
                    get() = "v"
                override val factors: List<Velocity>
                    get() = Velocity.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    (sqrt((8 * Constants.k * vars[1] * vars[1]) / (vars[0] * vars[2])))
            }
        )
}