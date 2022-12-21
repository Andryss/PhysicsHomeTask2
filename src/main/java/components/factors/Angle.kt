package components.factors

import components.Factor
import kotlin.math.PI

/*
Уголочек
 */
enum class Angle(override val label: String, override val factor: Double) : Factor {
    RADIAN("рад", 1e0),
    DEGREE("°", 2 * PI / 360)
}