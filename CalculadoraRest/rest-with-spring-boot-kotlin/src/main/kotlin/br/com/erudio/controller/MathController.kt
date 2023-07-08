package br.com.erudio.controller

import br.com.erudio.converters.NumberConverter.convertDouble
import br.com.erudio.converters.NumberConverter.isNumeric
import br.com.erudio.exceptions.UnsupportedMath
import br.com.erudio.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.sqrt

@RestController
class MathController {

    val counter : AtomicLong = AtomicLong()

    private val math: SimpleMath = SimpleMath()
@RequestMapping(value = ["/sum/{number1}/{number2}"])
    fun sum(@PathVariable(value="number1")number1: String?,
                    @PathVariable(value="number2")number2: String?
    ):Double
    {
        if(!isNumeric(number1) || !isNumeric(number2)) throw UnsupportedMath("Please set a numeric value ")
        return math.sum(convertDouble(number1),  convertDouble(number2))

    }
    @RequestMapping(value = ["/subtraction/{number1}/{number2}"])
    fun subtraction(@PathVariable(value="number1")number1: String?,
                    @PathVariable(value="number2")number2: String?
    ):Double
    {
        if(!isNumeric(number1) || !isNumeric(number2)) throw UnsupportedMath("Please set a numeric value ")
        return math.substraction(convertDouble(number1) , convertDouble(number2))

    }
    @RequestMapping(value = ["/multiplication/{number1}/{number2}"])
    fun Multiplication (@PathVariable(value="number1")number1: String?,
                        @PathVariable(value="number2")number2: String?
    ):Double
    {
        if(!isNumeric(number1) || !isNumeric(number2)) throw UnsupportedMath("Please set a numeric value ")
        return math.multiplication(convertDouble(number1) , convertDouble(number2))

    }
    @RequestMapping(value = ["/division/{number1}/{number2}"])
    fun Division (@PathVariable(value="number1")number1: String?,
                  @PathVariable(value="number2")number2: String?
    ):Double
    {
        if(!isNumeric(number1) || !isNumeric(number2)) throw UnsupportedMath("Please set a numeric value ")
        return math.division(convertDouble(number1) , convertDouble(number2))

    }   @RequestMapping(value = ["/average/{number1}/{number2}"])
    fun average (@PathVariable(value="number1")number1: String?,
                 @PathVariable(value="number2")number2: String?
    ):Double
    {
        if(!isNumeric(number1) || !isNumeric(number2)) throw UnsupportedMath("Please set a numeric value ")
        return math.mean(convertDouble(number1) , convertDouble(number2))

    }
    @RequestMapping(value = ["/squareroot/{number1}"])
    fun squareroot (@PathVariable(value="number1")number1: String?
    ):Double
    {
        if(!isNumeric(number1)) throw UnsupportedMath("Please set a numeric value ")
        return math.squreRoot(convertDouble(number1))

    }


}