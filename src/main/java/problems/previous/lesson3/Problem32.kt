package problems.previous.lesson3

import components.*
import components.factors.Number

@Suppress("unused")
class Problem32 : Problem {
    override val id: Int
        get() = 3

    override val label: String
        get() = "Задача 2"

    override val svgPath: String
        get() = "M 50 100 H 130 L 113 104 L 113 96 L 130 100 M 90 64 H 75 V 87 H 90 M 75 76 H 85 M 70 58 H 95 L 91 60 L 91 56 L 95 58 M 108 86 Q 102 78 108 69 M 114 83 C 121 87 120 70 114 72 M 124 72 C 118 70 117 87 124 83 M 128 83 C 129 83 129 84 128 85 M 132 72 C 132 85 140 85 140 72 C 140 86 142 91 136 91 C 133 91 140 80 142 80 M 146 86 Q 152 78 146 69 M 76 119 C 76 138 89 138 89 128 C 89 111 83 118 83 150 M 104 136 Q 98 127 104 119 M 110 133 C 117 137 116 120 110 122 M 120 133 C 113 137 114 120 120 122 M 124 133 C 125 133 125 134 124 135 M 128 122 C 128 135 136 135 136 122 C 136 136 138 141 132 141 C 129 141 136 130 138 130 M 142 136 Q 148 127 142 119"

    override val text: String
        get() = "Определить напряженность электрического поля, потенциал которого зависит \nот координат x, у по закону: а) φ = a(x²–y²); б) φ = axy; \nгде a — постоянная."

    override val variables: List<Variable<Factor>>
        get() = listOf(
            Number.Variable("a"),
            Number.Variable("x"),
            Number.Variable("y")
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Number.Answer("а) Ex") {
                override fun calculate(vars: List<Double>): Double =
                    (-2 * vars[0] * vars[1])
            },
            object : Number.Answer("а) Ey") {
                override fun calculate(vars: List<Double>): Double =
                    (2 * vars[0] * vars[2])
            },
            object : Number.Answer("б) Ex") {
                override fun calculate(vars: List<Double>): Double =
                    (- vars[0] * vars[2])
            },
            object : Number.Answer("б) Ey") {
                override fun calculate(vars: List<Double>): Double =
                    (- vars[0] * vars[1])
            }
        )
}