package to.grindelf.numericalmethodspart4

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.offset
import org.junit.jupiter.api.Test
import to.grindelf.numericalmethodspart4.SimpsonsFormula.simpsonIntegrate
import to.grindelf.numericalmethodspart4.TrapezoidFormula.trapezoidalIntegral

class MethodsDemonstration {
    @Test
    fun `GIVEN determined integral function WHEN Simpsons formula is applied THEN expected number of divisions returned integral value and integral value`() {
        val integral = SimpsonsFormula.solution()
        val richardsonIntegral = richardsonIntegrate(integral.numberOfDivisions, SIMPSON_R, ::simpsonIntegrate)

        println("Method: ${SimpsonsFormula::class.java.simpleName}, integral = $integral")
        println("Method: richardson, integral = ${String.format("%.6f", richardsonIntegral)}")

        assertThat(integral.integral).isCloseTo(richardsonIntegral, offset(1e-5))
    }

    @Test
    fun `GIVEN determined integral function WHEN Trapezoid formula is applied THEN expected number of divisions returned integral value and integral value`() {
        val integral = TrapezoidFormula.solution()
        val richardsonIntegral = richardsonIntegrate(integral.numberOfDivisions, TRAPEZOID_R, ::trapezoidalIntegral)

        println("Method: ${TrapezoidFormula::class.java.simpleName}, integral = $integral")
        println("Method: richardson, integral = ${String.format("%.6f", richardsonIntegral)}")

        assertThat(integral.integral).isCloseTo(richardsonIntegral, offset(1e-5))
    }
}
