package problems.previous.lesson3

import components.*
import components.factors.electromagnetism.complex.ElectricField
import components.factors.mechanics.Length
import components.factors.electromagnetism.Potential
import components.factors.electromagnetism.complex.SurfaceChargeDensity
import kotlin.math.sqrt

@Suppress("unused")
class Problem37 : Problem {
    override val id: Int
        get() = 3

    override val label: String
        get() = "Задача 7"

    override val svgPath: String
        get() = "M 80 100 H 160 M 160 101 C 161 101 161 99 160 99 C 159 99 159 101 160 101 M 80 30 C 114 30 114 170 79 170 C 45 170 47 30 80 30 M 80 100 L 56 117 L 62 115 L 60 112 L 56 117 M 69 133 L 69 116 C 78 116 78 125 69 125 L 76 133 M 111 41 C 115 42 117 51 111 51 C 107 50 104 41 111 41 C 113 41 116 43 117 41 M 132 92 C 139 87 138 78 135 82 C 132 86 132 100 137 95"

    override val text: String
        get() = "Находящаяся в вакууме круглая очень тонкая пластинка радиуса R равномерно \nзаряжена с поверхностной плотностью σ. Найти потенциал и напряженность \nэлектрического поля на оси пластинки как функцию расстояния l от ее центра. \nИсследовать полученное выражение при l → 0 и l >> R"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            Length.Variable("R"),
            object : Variable<SurfaceChargeDensity> {
                override val label: String
                    get() = "σ"
                override val factors: List<SurfaceChargeDensity>
                    get() = SurfaceChargeDensity.values().toList()
            },
            Length.Variable("l")
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Answer<ElectricField> {
                override val label: String
                    get() = "E"
                override val factors: List<ElectricField>
                    get() = ElectricField.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    ((vars[1] / (2 * Constants.e0)) * (1 - 1 / sqrt(1 + (vars[0] / vars[2]) * (vars[0] / vars[2]))))
            },
            object : Answer<ElectricField> {
                override val label: String
                    get() = "E (l → 0)"
                override val factors: List<ElectricField>
                    get() = ElectricField.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    (vars[1] / (2 * Constants.e0))
            },
            object : Answer<ElectricField> {
                override val label: String
                    get() = "E (l >> R)"
                override val factors: List<ElectricField>
                    get() = ElectricField.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    (0.0)
            },
            object : Answer<Potential> {
                override val label: String
                    get() = "φ"
                override val factors: List<Potential>
                    get() = Potential.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    (((vars[1] * vars[2]) / (2 * Constants.e0)) * (sqrt(1 + (vars[0] / vars[2]) * (vars[0] / vars[2])) - 1))
            },
            object : Answer<Potential> {
                override val label: String
                    get() = "φ (l → 0)"
                override val factors: List<Potential>
                    get() = Potential.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    (((vars[1] * vars[0]) / (2 * Constants.e0)))
            },
            object : Answer<Potential> {
                override val label: String
                    get() = "φ (l >> R)"
                override val factors: List<Potential>
                    get() = Potential.values().toList()
                override fun calculate(vars: List<Double>): Double =
                    (0.0)
            }
        )
}