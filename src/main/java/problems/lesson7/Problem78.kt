package problems.lesson7

import components.Answer
import components.Factor
import components.Problem
import components.Variable
import components.factors.electromagnetism.Charge
import components.factors.mechanics.Heat
import components.factors.electromagnetism.Resistance
import components.factors.Time
import util.MathUtil
import kotlin.math.abs

@Suppress("unused")
class Problem78 : Problem {
    override val id: Int
        get() = 7

    override val label: String
        get() = "Задача 8"

    override val svgPath: String
        get() = "M 15 50 H 35 C 35 40 40 35 45 35 C 50 35 50 60 45 60 C 40 60 55 35 60 35 C 65 35 65 60 60 60 C 55 60 70 35 75 35 C 80 35 80 60 75 60 C 70 60 85 35 90 35 C 95 35 100 40 100 50 H 120 M 105 35 V 5 C 120 5 120 20 105 20 L 116 35 M 100 180 V 90 L 95 100 H 105 L 100 90 M 100 180 H 190 L 180 185 V 175 L 190 180 M 100 120 L 165 180 M 75 85 H 90 M 82 85 V 110 M 75 110 H 90 M 180 155 C 185 153 190 157 195 155 M 188 155 C 186 161 185 173 190 170 M 115 105 V 120 M 110 105 H 120 M 110 120 H 120 M 125 118 A 1 1 0 0 0 125 123 A 1 1 0 0 0 125 118 M 160 150 C 160 157 158 165 165 165 M 155 155 H 165"

    override val text: String
        get() = "Сколько тепла выделится в спирали сопротивлением R при прохождении через \nнее количества электричества q, если ток в спирали равномерно убывал \nдо нуля в течение времени t"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            object : Variable<Resistance> {
                override val label: String
                    get() = "R"
                override val factors: List<Resistance>
                    get() = Resistance.values().toList()
            },
            object : Variable<Charge> {
                override val label: String
                    get() = "q"
                override val factors: List<Charge>
                    get() = Charge.values().toList()
            },
            object : Variable<Time> {
                override val label: String
                    get() = "t"
                override val factors: List<Time>
                    get() = Time.values().toList()
            }
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Answer<Heat> {
                override val label: String
                    get() = "Q"
                override val factors: List<Heat>
                    get() = Heat.values().toList()
                override fun calculate(vars: List<Double>): Double {
                    val R = vars[0]
                    val q = vars[1]
                    val t = vars[2]
                    if (abs(t) < 1e-10) return 0.0
                    val func : (Double) -> Double = { time ->
                        val I = 2.0 * q / (t * t) * time - 2 * q / t
                        I * I * R
                    }
                    return MathUtil.integral(0.0, t, t * 1e-6, func)
                }
            }
        )
}