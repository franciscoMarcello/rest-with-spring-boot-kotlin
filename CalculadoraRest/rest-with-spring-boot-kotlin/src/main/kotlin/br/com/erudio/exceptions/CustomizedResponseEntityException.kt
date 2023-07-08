package br.com.erudio.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
@RestController
class CustomizedResponseEntityException : ResponseEntityExceptionHandler(){
    @ExceptionHandler(Exception::class)
 fun handleAllException(ex: Exception, request: WebRequest) : ResponseEntity<ExceptionResponse> {
    val execptionResponse = ExceptionResponse(
        Date(),
        ex.message,
        request.getDescription(false)
    )
     return ResponseEntity<ExceptionResponse>(execptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
 }
    @ExceptionHandler(UnsupportedMath::class)
 fun handleBadRequest(ex: Exception, request: WebRequest) : ResponseEntity<ExceptionResponse> {
    val execptionResponse = ExceptionResponse(
        Date(),
        ex.message,
        request.getDescription(false)
    )
     return ResponseEntity<ExceptionResponse>(execptionResponse, HttpStatus.BAD_REQUEST)
 }
}