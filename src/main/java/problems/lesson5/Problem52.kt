package problems.lesson5

import components.*
import components.factors.*
import kotlin.math.PI

@Suppress("unused")
class Problem52 : Problem {
    override val id: Int
        get() = 5

    override val label: String
        get() = "Задача 2"

    override val svgPath: String
        get() = "M 190 50 A 1 1 0 0 0 100 50 A 1 1 0 0 0 190 50 M 145 50 L 177 21 L 172 31 L 166 25 L 177 21 M 165 65 V 40 C 180 40 180 54 165 54 L 176 65 M 140 63 C 140 55 130 55 130 63 C 130 71 140 71 140 60 C 135 83 139 90 145 81 M 140 17 C 125 15 125 28 136 28 C 125 28 125 42 140 40 M 10 190 L 10 80 L 14 90 L 6 90 L 10 80 M 10 190 H 155 L 145 194 L 145 186 L 155 190 M 55 92 C 69 120 112 128 145 130 M 24 130 C 32 151 52 165 75 170 V 150 C 92 171 121 177 145 180 M 160 110 C 178 110 178 140 160 140 V 110 M 175 155 H 160 V 185 H 175 M 160 170 H 170 M 180 140 C 175 133 175 127 180 120 M 184 122 V 138 C 184 122 192 121 192 124 M 195 120 C 200 126 200 133 195 140 M 180 185 C 175 178 175 172 180 165 M 184 167 V 183 C 184 167 192 166 192 169 M 195 165 C 200 172 200 178 195 185"

    override val text: String
        get() = "Точечный заряд q находится в центре шара радиусом R из однородного \nизотропного диэлектрика проницаемостью ε. Найти напряженность поля как \nфункцию расстояния r от центра шара. \nПредставить графики зависимостей E(r) и D(r)."

    override val variables: List<Variable<Factor>>
        get() = listOf(
            object : Variable<Charge> {
                override val label: String
                    get() = "q"
                override val factors: List<Charge>
                    get() = Charge.values().toList()
            },
            object : Variable<Length> {
                override val label: String
                    get() = "R"
                override val factors: List<Length>
                    get() = Length.values().toList()
            },
            object : Variable<Permittivity> {
                override val label: String
                    get() = "ε"
                override val factors: List<Permittivity>
                    get() = Permittivity.values().toList()
            },
            object : Variable<Length> {
                override val label: String
                    get() = "r"
                override val factors: List<Length>
                    get() = Length.values().toList()
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
                    if (vars[3] <= vars[1])
                        ((Constants.k * vars[0]) / (vars[3] * vars[3] * vars[2]))
                    else
                        ((Constants.k * vars[0]) / (vars[3] * vars[3]))
            },
            object : Answer<ElectricDisplacementField> {
                override val label: String
                    get() = "D"
                override val factors: List<ElectricDisplacementField>
                    get() = ElectricDisplacementField.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    (vars[0] / (4 * PI * vars[3] * vars[3]))
            }
        )
}