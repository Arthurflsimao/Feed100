package sptech.projetojpa.servico

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

/*
Uma classe de teste pode ou não ser internal
Isso não influencia no resultado
 */
internal class CalculadoraServiceTest {

    // este objeto poderá ser usado em todos os testes
    val calculadora = CalculadoraService()

    @Test
    fun `calcularVT() deve calcular corretamente`() {
        // preparação do teste
        val calculadora = CalculadoraService()

        // execução do teste
        val resultado = calculadora.calcularVT(2.0, 2, 20)

        // verificação do teste
        assertEquals(80.0, resultado)


        // execução do teste
        val resultado2 = calculadora.calcularVT(3.0, 4, 22)

        // verificação do teste
        assertEquals(264.0, resultado2)

        // execução do teste
        val resultado3 = calculadora.calcularVT(3.0, 4, 0)

        // verificação do teste
        assertEquals(0.0, resultado3)
    }

    @Test
    fun `valores negativos devem dar erro`() {
        // preparação do teste
        val calculadora = CalculadoraService()

        // execução E verificação
        /*
Aqui estamos verificando se é lançada a exceção
IllegalArgumentException quando executamos o código dentro
do bloco Execute {}
         */
        assertThrows(IllegalArgumentException::class.java,
            Executable { calculadora.calcularVT(3.0, 4, -20) }
        )
        assertThrows(IllegalArgumentException::class.java,
            Executable { calculadora.calcularVT(3.0, -4, 20) }
        )
        assertThrows(IllegalArgumentException::class.java,
            Executable { calculadora.calcularVT(-3.0, 4, 20) }
        )
        assertThrows(IllegalArgumentException::class.java,
            Executable { calculadora.calcularVT(-3.0, -4, -20) }
        )
    }

    @ParameterizedTest
    @CsvSource(
        "2.0, 2, 20, 80",
        "3.0, 4, 22, 264",
        "3.0, 4, 0, 0",
        "3.0, 0, 20, 0",
        "0.0, 4, 0, 0"
    )
    fun `cálulo de VT deve estar correto`(valorPassagem:Double,
        passagensDia:Int, diasUteis:Int, resultadoEsperado:Double) {

        // execução
        val resultado = calculadora.calcularVT(
            valorPassagem, passagensDia, diasUteis)

        // verificação
        assertEquals(resultadoEsperado, resultado)
    }

    @ParameterizedTest
    @CsvSource(
        "3.0, 4, -20",
        "3.0, -4, 20",
        "-3.0, 4, 20",
        "-3.0, -4, -20"
    )
    fun `valores negativos devem dar erro`(
            valorPassagem:Double, passagensDia:Int, diasUteis:Int) {
        // execução E verificação
        assertThrows(IllegalArgumentException::class.java,
            Executable {
                calculadora.calcularVT(valorPassagem, passagensDia, diasUteis)
            }
        )
    }

}



