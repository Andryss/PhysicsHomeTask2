package problems.lesson6

import components.*
import components.factors.electromagnetism.Charge
import components.factors.electromagnetism.complex.ElectricField
import components.factors.electromagnetism.Permittivity
import components.factors.electromagnetism.complex.SurfaceChargeDensity
import components.factors.mechanics.Length
import kotlin.math.PI

@Suppress("unused")
class Problem64 : Problem {
    override val id: Int
        get() = 6

    override val label: String
        get() = "Задача 4"

    override val svgPath: String
        get() = "M 100 20 A 1 1 0 0 0 100 180 A 1 1 0 0 0 100 20 M 100 200 V 0 L 103 7 H 97 L 100 0 M 145 25 H 135 V 5 H 145 M 135 15 H 142 M 130 2 H 150 L 145 0 L 145 4 L 150 2 M 55 105 C 45 99 41 113 52 113 C 41 113 45 125 55 120 M 85 30 H 95 M 90 25 V 35 M 105 30 H 115 M 110 25 V 35 M 125 40 H 135 M 130 35 V 45 M 65 40 H 75 M 70 35 V 45 M 105 170 H 115 M 125 160 H 135 M 85 170 H 95 M 65 160 H 75 M 69 9 C 74 9 76 20 70 20 C 62 20 61 8 71 8 C 75 8 76 10 79 10 M 20 100 H 180 M 130 65 C 130 57 120 57 120 65 C 120 73 130 72 131 62 C 128 75 126 90 135 81"

    override val text: String
        get() = "Внутри шара из однородного изотропного диэлектрика с ε создано однородное \nэлектрическое поле с напряженностью E. Найти максимальную поверхностную \nплотность σ'макс связанных зарядов и полный связанный заряд q одного знака"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            Permittivity.simpleVariable,
            ElectricField.simpleVariable,
            Length.Variable("R")
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : SurfaceChargeDensity.Answer("σ'макс") {
                override fun calculate(vars: List<Double>): Double =
                    ((vars[0] - 1) * Constants.e0 * vars[1])
            },
            object : Charge.Answer() {
                override fun calculate(vars: List<Double>): Double =
                    ((vars[0] - 1) * Constants.e0 * vars[1] * vars[2] * vars[2] * PI)
            }
        )
}