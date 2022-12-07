package problems.lesson9

import components.*
import components.factors.electromagnetism.CurrentDensity
import components.factors.electromagnetism.MagneticField
import components.factors.mechanics.Length

@Suppress("unused")
class Problem95 : Problem {
    override val id: Int
        get() = 9

    override val label: String
        get() = "Задача 5"

    override val svgPath: String
        get() = "M 190 100 A 1 1 0 0 0 10 100 A 1 1 0 0 0 190 100 M 20 100 A 1 1 0 0 0 65 100 A 1 1 0 0 0 20 100 M 100 100 L 43 100 L 100 100 M 71 118 C 79 109 78 101 75 106 C 71 116 72 128 77 121 M 43 100 L 50 103 L 50 97 L 43 100 M 115 105 C 105 105 105 125 115 125 C 124 125 125 105 115 105 M 99 100 A 1 1 0 0 0 101 100 A 1 1 0 0 0 99 100 M 28 110 V 90 C 36 90 37 100 28 100 C 39 100 39 110 28 110"

    override val text: String
        get() = "Внутри однородного длинного прямого провода круглого сечения имеется \nкруглая цилиндрическая полость, ось которой параллельна оси провода и \nсмещена относительно последней на расстояние l. По проводу течёт \nпостоянный ток плотности j. Найти магнитную индукцию В внутри полости."

    override val variables: List<Variable<Factor>>
        get() = listOf(
            object : Variable<CurrentDensity> {
                override val label: String
                    get() = "j"
                override val factors: List<CurrentDensity>
                    get() = CurrentDensity.values().toList()
            },
            object : Variable<Length> {
                override val label: String
                    get() = "l"
                override val factors: List<Length>
                    get() = Length.values().toList()
            }
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Answer<MagneticField> {
                override val label: String
                    get() = "B"
                override val factors: List<MagneticField>
                    get() = MagneticField.values().toList()

                override fun calculate(vars: List<Double>): Double {
                    val j = vars[0]
                    val l = vars[1]
                    return (Constants.mu0 * j * l) / 2
                }
            }
        )
}