package components

import kotlin.math.PI

class Constants {
    companion object {
        const val e0 = 8.85e-12
        const val k = 1 / (4 * PI * e0)
        const val mu0 = 4 * PI * 1e-7
    }
}