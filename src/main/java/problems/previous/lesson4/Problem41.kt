package problems.previous.lesson4

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
        get() = "M 30 100 H 120 M 29 100 C 29 99 31 99 31 100 C 31 101 29 101 29 100 M 119 100 C 119 99 121 99 121 100 C 121 101 119 101 119 100 M 131 100 H 137 M 145 100 H 151 M 156 100 L 170 100 M 156 100 L 160 101 L 160 99 M 160 99 L 156 100 M 154 109 C 160 105 155 121 160 121 C 165 121 160 105 166 109 M 153 106 H 166 L 163 107 L 163 105 L 166 106 M 169 100 C 169 99 171 99 171 100 C 171 101 169 101 169 100 M 30 105 L 24 123 M 36 123 L 30 105 M 26 117 H 34 M 117 105 V 123 C 130 123 129 114 117 114 C 129 114 128 105 117 105 M 74 115 C 80 102 76 101 75 105 C 73 113 76 124 78 119 M 22 86 H 28 M 25 83 V 89 M 38 82 C 38 76 31 76 31 82 C 31 89 38 90 38 82 C 39 95 33 97 31 90 M 48 86 C 48 79 41 79 41 86 C 41 91 48 91 48 84 C 44 102 48 98 49 93 M 106 86 H 112 M 123 85 C 123 78 116 78 116 85 C 116 92 123 91 123 81 C 119 102 124 98 125 92 M 159 86 H 165 M 176 85 C 176 78 169 78 169 85 C 169 92 176 92 176 82 C 172 102 177 99 178 93 M 170 108 V 121 C 170 104 176 104 176 121 C 176 104 182 104 182 121"

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