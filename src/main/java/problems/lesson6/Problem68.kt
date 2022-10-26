package problems.lesson6

import components.Answer
import components.Factor
import components.Problem
import components.Variable
import components.factors.Capacitance
import kotlin.math.sqrt

@Suppress("unused")
class Problem68 : Problem {
    override val id: Int
        get() = 6

    override val label: String
        get() = "Задача 8"

    override val svgPath: String
        get() = "M 15 80 A 1 1 0 0 0 25 80 A 1 1 0 0 0 15 80 M 25 80 H 45 M 45 65 V 95 M 55 65 V 95 M 55 80 H 95 M 95 65 V 95 M 105 65 V 95 M 105 80 H 145 M 125 80 V 95 M 110 95 H 140 M 110 105 H 140 M 125 105 V 120 M 75 80 V 95 M 60 95 H 90 M 60 105 H 90 M 75 105 V 120 M 145 120 H 25 A 1 1 0 0 0 15 120 A 1 1 0 0 0 25 120 M 155 80 H 165 M 175 80 H 185 M 155 120 H 165 M 175 120 H 185 M 40 35 C 25 30 25 70 40 60 M 80 130 C 65 125 65 165 80 155 M 90 60 C 75 70 75 30 90 35 M 130 130 C 115 125 115 165 130 155"

    override val text: String
        get() = "Найти емкость бесконечной цепи, которая образована повторением одного и \nтого же звена, состоящего из двух одинаковых конденсаторов, \nкаждый емкости C (рисунок)"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            object : Variable<Capacitance> {
                override val label: String
                    get() = "C"
                override val factors: List<Capacitance>
                    get() = Capacitance.values().toList()
            }
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Answer<Capacitance> {
                override val label: String
                    get() = "C"
                override val factors: List<Capacitance>
                    get() = Capacitance.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    (vars[0] * (sqrt(5.0) - 1) / 2)
            }
        )
}