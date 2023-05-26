package to.grindelf.numericalmethodspart4

import kotlin.math.abs

object SimpsonsFormula {
    fun solution(): Result {
        var counterOfIterations = 0
        var n = INITIAL_N
        var integralm = simpsonIntegrate(n)
        var integral2m = simpsonIntegrate(n * 2)

        while (abs(integralm - integral2m) > 0.00001) {
            counterOfIterations++
            n *= 2
            integralm = simpsonIntegrate(n)
            integral2m = simpsonIntegrate(n * 2)
        }
        return Result(integral2m, n * 2, counterOfIterations)
    }


     fun simpsonIntegrate(n: Int): Double {
        val h = (B - A) / n.toDouble()
        var sum = (mainFunction(A) + mainFunction(B)) / 3.0

        for (i in 1 until n) {
            val x = A + i * h
            sum += when {
                i % 2 == 0 -> 2 * mainFunction(x) / 3.0
                else -> 4 * mainFunction(x) / 3.0
            }
        }

        return h * sum
    }
}