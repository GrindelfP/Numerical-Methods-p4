package to.grindelf.numericalmethodspart4

import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.reflect.KFunction1

fun mainFunction(x: Double): Double = 1 / (1 + sqrt(ln(x)))

const val A = 2.0

const val B = 3.0

const val INITIAL_N = 2

const val TRAPEZOID_R = 2

const val SIMPSON_R = 4

data class Result(val integral: Double, val numberOfDivisions: Int, val numberOfIterations: Int) {
    override fun toString(): String {
        return "${
            String.format(
                "%.6f",
                integral
            )
        }, numberOfDivisions=$numberOfDivisions, numberOfIterations=$numberOfIterations"
    }
}

fun richardsonIntegrate(n: Int, r: Int, integrate: KFunction1<Int, Double>): Double {
    val coefficient = 2.0.pow(r)
    val integral = integrate((n / 2.0).toInt())
    val integral2 = integrate(n)

    return (coefficient * integral2 - integral) / (coefficient - 1)
}
