package problems.lesson10

import components.Answer
import components.Factor
import components.Problem
import components.Variable
import components.factors.Time
import components.factors.electromagnetism.ElectromotiveForce
import components.factors.electromagnetism.complex.MagneticFieldPerTime
import components.factors.mechanics.complex.Acceleration
import components.factors.mechanics.Length

@Suppress("unused")
class Problem101 : Problem {
    override val id: Int
        get() = 10

    override val label: String
        get() = "Задача 1"

    override val svgPath: String
        get() = "M 170 70 H 30 V 130 H 170 M 110 60 V 67 A 1 1 0 0 0 110 73 V 127 A 1 1 0 0 0 110 133 V 140 M 119 91 H 136 L 132 93 L 132 89 L 136 91 M 131 102 C 131 99 124 98 124 104 C 124 111 131 111 131 100 C 130 108 132 111 133 108 M 93 102 C 102 91 96 88 95 93 C 93 102 94 112 98 106 M 61 84 L 68 91 M 61 91 L 68 84 M 61 113 L 68 120 M 61 120 L 68 113 M 38 111 V 89 C 49 89 49 100 38 100 C 51 100 51 111 38 111 M 35 85 H 52 L 47 83 L 47 87 L 52 85"

    override val text: String
        get() = "П-образный проводник находится в однородном магнитном поле, \nперпендикулярном к плоскости проводника и изменяющемся во времени со \nскоростью ΔB. Вдоль параллельных сторон этого проводника перемещают \nбез начальной скорости проводник-перемычку с ускорением a. \nДлина перемычки l. Найти э. д. с. индукции в контуре через t \nпосле начала перемещения, если в момент t = 0 площадь контура и индукция \nмагнитного поля равны нулю. Индуктивностью контура пренебречь"

    override val variables: List<Variable<Factor>>
        get() = listOf(
            object : Variable<MagneticFieldPerTime> {
                override val label: String
                    get() = "ΔB"
                override val factors: List<MagneticFieldPerTime>
                    get() = MagneticFieldPerTime.values().toList()
            },
            object : Variable<Acceleration> {
                override val label: String
                    get() = "a"
                override val factors: List<Acceleration>
                    get() = Acceleration.values().toList()
            },
            object : Variable<Length> {
                override val label: String
                    get() = "l"
                override val factors: List<Length>
                    get() = Length.values().toList()
            },
            object : Variable<Time> {
                override val label: String
                    get() = "t"
                override val factors: List<Time>
                    get() = Time.values().toList()
            }
        )

    override val answers: List<Answer<Factor>>
        get() = listOf(
            object : Answer<ElectromotiveForce> {
                override val label: String
                    get() = "ε"
                override val factors: List<ElectromotiveForce>
                    get() = ElectromotiveForce.values().toList()

                override fun calculate(vars: List<Double>): Double {
                    val dB = vars[0]
                    val a = vars[1]
                    val l = vars[2]
                    val t = vars[3]
                    return 3/2 * dB * l * a * t * t
                }
            }
        )
}