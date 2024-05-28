package problems.lesson7

import components.Answer
import components.Factor
import components.Problem
import components.Variable
import components.factors.electromagnetism.Resistance
import kotlin.math.sqrt

@Suppress("unused")
class Problem73 : Problem {
    override val id: Int
        get() = 7

    override val label: String
        get() = "Задача 3"

    override val svgPath: String
        get() = "M 15 80 A 1 1 0 0 0 25 80 A 1 1 0 0 0 15 80 M 25 80 H 40 M 40 70 V 90 H 60 V 70 M 60 70 H 40 M 60 80 H 90 M 90 70 V 90 H 110 V 70 M 110 70 H 90 M 110 80 H 145 M 125 80 V 90 M 115 90 V 110 M 115 110 H 135 V 90 H 115 M 125 110 V 120 M 75 80 V 90 M 65 90 V 110 M 65 110 H 85 V 90 H 65 M 75 110 V 120 M 145 120 H 25 A 1 1 0 0 0 15 120 A 1 1 0 0 0 25 120 M 155 80 H 165 M 175 80 H 185 M 155 120 H 165 M 175 120 H 185 M 30 60 V 30 C 45 30 45 45 30 45 L 41 60 M 70 160 V 130 C 85 130 85 145 70 145 L 81 160 M 80 60 V 30 C 95 30 95 45 80 45 L 91 60 M 120 160 V 130 C 135 130 135 145 120 145 L 131 160"

    override val text: String
        get() = "Определите сопротивление R₀ бесконечной цепи, показанной на рисунке"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            Resistance.simpleVariable
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Resistance.Answer("R₀") {
                override fun calculate(vars: List<Double>): Double {
                    val R = vars[0]
                    return R/2 * (1 + sqrt(5.0))
                }
            }
        )

}