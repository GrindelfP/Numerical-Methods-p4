package to.grindelf.numericalmethodspart4

import kotlin.math.abs

object TrapezoidFormula {

    fun solution(): Result {
        var counterOfIterations = 0
        var n = INITIAL_N
        var integralm = trapezoidalIntegral(n)
        var integral2m = trapezoidalIntegral(n * 2)

        while (abs(integralm - integral2m) > 0.00001) {
            counterOfIterations++
            n *= 2
            integralm = trapezoidalIntegral(n)
            integral2m = trapezoidalIntegral(n * 2)
        }

        return Result(integral2m, n * 2, counterOfIterations)
    }

    fun trapezoidalIntegral(n: Int): Double {
        val h = (B - A) / n.toDouble()
        var sum = 0.5 * (mainFunction(A) + mainFunction(B))
        for (i in 1 until n) {
            val x = A + i * h
            sum += mainFunction(x)
        }

        return h * sum
    }
}