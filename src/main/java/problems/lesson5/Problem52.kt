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
        get() = ""

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