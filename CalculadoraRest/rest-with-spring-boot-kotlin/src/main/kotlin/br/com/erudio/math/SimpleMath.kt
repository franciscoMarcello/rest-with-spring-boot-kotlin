package br.com.erudio.math

import br.com.erudio.converters.NumberConverter
import br.com.erudio.exceptions.UnsupportedMath
import org.springframework.web.bind.annotation.PathVariable
import kotlin.math.sqrt

class SimpleMath {
    fun sum(number1: Double,number2: Double) = number1 + number2
    fun substraction(number1: Double,number2: Double) = number1 - number2
    fun multiplication(number1: Double,number2: Double) = number1 * number2
    fun division(number1: Double,number2: Double) = number1 / number2
    fun mean(number1: Double,number2: Double) = (number1 + number2)/2
    fun squreRoot(number: Double) = sqrt(number)

}