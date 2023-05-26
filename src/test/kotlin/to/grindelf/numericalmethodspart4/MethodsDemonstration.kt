package to.grindelf.numericalmethodspart4

import org.junit.jupiter.api.Test
import to.grindelf.numericalmethodspart4.SimpsonsFormula.simpsonIntegrate
import to.grindelf.numericalmethodspart4.TrapezoidFormula.trapezoidalIntegral

class MethodsDemonstration {
    @Test
    fun simpson() {
        val integral = SimpsonsFormula.solution()
        val richardsonIntegral = richardsonIntegrate(integral.numberOfDivisions, SIMPSON_R, ::simpsonIntegrate)

        println("Method: ${SimpsonsFormula::class.java.simpleName}, integral = $integral")
        println("Method: richardson, integral = ${String.format("%.6f", richardsonIntegral)}")
    }

    @Test
    fun trapezoid() {
        val integral = TrapezoidFormula.solution()
        val richardsonIntegral = richardsonIntegrate(integral.numberOfDivisions, TRAPEZOID_R, ::trapezoidalIntegral)

        println("Method: ${TrapezoidFormula::class.java.simpleName}, integral = $integral")
        println("Method: richardson, integral = ${String.format("%.6f", richardsonIntegral)}")
    }
}