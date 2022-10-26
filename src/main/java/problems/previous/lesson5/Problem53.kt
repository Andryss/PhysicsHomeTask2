package problems.previous.lesson5

import components.Answer
import components.Factor
import components.Problem
import components.Variable
import components.factors.Angle
import components.factors.ElectricField
import components.factors.Permittivity
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

@Suppress("unused")
class Problem53 : Problem {
    override val id: Int
        get() = 5

    override val label: String
        get() = "Задача 3"

    override val svgPath: String
        get() = "M 80 10 V 190 M 120 10 V 190 M 40 170 L 80 110 L 75 126 L 67 120 L 80 110 L 120 90 L 110 102 L 104 92 L 120 90 L 160 30 L 157 45 L 148 39 L 160 30 M 40 170 H 80 M 47 160 C 52 162 53 166 53 170 M 71 150 C 69 162 61 168 61 161 C 61 153 71 163 75 163 M 45 115 H 30 V 145 H 45 M 30 130 H 40 M 50 138 C 46 138 46 148 50 148 C 54 148 54 138 50 138 M 25 110 H 50 L 42 107 L 42 113 L 50 110 M 110 125 H 95 V 155 H 110 M 95 140 H 105 M 90 120 H 115 L 107 117 L 107 123 L 115 120 M 105 30 C 90 28 90 40 100 40 C 90 40 90 52 105 50"

    override val text: String
        get() = "Тонкая пластина из диэлектрика с Диэлектрической проницаемостью ε помещена \nв однородное электрическое поле так, что нормаль к ее поверхности составляет \nугол α с напряженностью E₀. Найти напряженность электрического поля внутри \nдиэлектрика"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            object : Variable<Permittivity> {
                override val label: String
                    get() = "ε"
                override val factors: List<Permittivity>
                    get() = Permittivity.values().toList()
            },
            object : Variable<Angle> {
                override val label: String
                    get() = "α"
                override val factors: List<Angle>
                    get() = Angle.values().toList()
            },
            object : Variable<ElectricField> {
                override val label: String
                    get() = "E₀"
                override val factors: List<ElectricField>
                    get() = ElectricField.values().toList()
            }
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Answer<ElectricField> {
                override val label: String
                    get() = "E"
                override val factors: List<ElectricField>
                    get() = ElectricField.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    (vars[2] / vars[0] * sqrt(cos(vars[1]) * cos(vars[1]) + vars[0] * vars[0] * sin(vars[1]) * sin(vars[1])))
            }
        )
}