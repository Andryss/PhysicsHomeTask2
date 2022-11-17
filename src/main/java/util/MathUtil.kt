package util

import java.util.function.DoubleFunction

class MathUtil {

    companion object {

        fun integral(left: Double, right: Double, step: Double, function: DoubleFunction<Double>) : Double {
            var value = 0.0

            var leftCur = left
            var rightCur = left + step
            while (rightCur <= right) {
                value += function.apply((leftCur + rightCur) / 2) * step
                leftCur = rightCur
                rightCur += step
            }

            return value
        }

    }

}