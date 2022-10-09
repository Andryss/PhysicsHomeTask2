package problems.previous.lesson2

import components.Constants.Companion.k
import components.*
import components.factors.ElectricField
import components.factors.Length
import components.factors.LinearChargeDensity
import kotlin.math.sqrt

@Suppress("unused")
class Problem24 : Problem {
    override val id: Int
        get() = 2

    override val label: String
        get() = "Задача 4"

    override val svgPath: String
        get() = "M 100 20 Q 180 20 180 100 M 100 100 L 40 160 L 49 156 L 44 151 L 40 160 M 100 100 L 179 83 L 173 87 L 172 82 L 179 83 M 50 137 H 41 V 124 H 50 M 41 131 H 47 M 144 113 V 101 C 152 101 152 107 144 107 L 150 113 M 173 42 C 171 42 172 32 167 32 M 171 36 C 169 38 169 41 167 42"

    override val text: String
        get() = "Найти напряженность поля равномерно заряженной нити \nв виде четверти кольца в точке центра его кривизны. \nЛинейная плотность заряда нити λ. Радиус R."

    override val variables: List<Variable<Factor>>
        get() = listOf(
            object : Variable<LinearChargeDensity> {
                override val label: String
                    get() = "λ"
                override val factors: List<LinearChargeDensity>
                    get() = LinearChargeDensity.values().toList()
            },
            object : Variable<Length> {
                override val label: String
                    get() = "R"
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
                    ((sqrt(2.0) * k * vars[0]) / vars[1])
            }
        )
}