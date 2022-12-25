package problems.previous.lesson6

import components.Answer
import components.Factor
import components.Problem
import components.Variable
import components.factors.electromagnetism.Capacitance
import components.factors.mechanics.Energy
import components.factors.electromagnetism.Voltage

@Suppress("unused")
class Problem67 : Problem {
    override val id: Int
        get() = 6

    override val label: String
        get() = "Задача 7"

    override val svgPath: String
        get() = "M 15 100 H 45 M 45 85 V 115 M 60 85 V 115 M 60 100 H 90 M 35 130 C 20 124 19 164 35 155 M 40 155 L 45 150 V 160 M 65 150 C 65 160 75 160 75 150 V 130 M 65 130 V 150 M 115 100 V 125 H 130 M 130 110 V 140 M 145 110 V 140 M 145 125 H 160 V 100 M 115 100 V 75 H 130 M 130 60 V 90 M 145 60 V 90 M 145 75 H 160 V 100 M 120 155 C 105 147 103 187 120 180 M 125 180 L 130 175 V 185 M 150 155 V 175 C 150 185 160 185 160 175 V 155 M 165 180 L 170 175 V 185 M 125 25 C 110 19 109 57 125 50 M 130 45 H 135 V 50 H 130 V 55 H 135 M 150 25 V 45 C 150 55 160 55 160 45 V 25 M 165 45 H 170 V 50 H 165 V 55 H 170"

    override val text: String
        get() = "Конденсатор емкости C₁, предварительно заряженный до напряжения U, \nподключили параллельно к незаряженному конденсатору емкости C₂. Найти \nизменение электрической энергии этой системы к моменту установления \nравновесия"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            Capacitance.Variable("C₁"),
            Voltage.simpleVariable,
            Capacitance.Variable("C₂")
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Energy.Answer() {
                override fun calculate(vars: List<Double>): Double =
                    ((vars[1] * vars[1] * vars[0]) / 2 * (vars[0] / (vars[0] + vars[2]) - 1))
            }
        )
}