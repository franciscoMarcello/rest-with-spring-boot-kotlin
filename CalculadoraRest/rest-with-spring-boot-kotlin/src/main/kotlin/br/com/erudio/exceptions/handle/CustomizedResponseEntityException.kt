package br.com.erudio.exceptions.handle

import br.com.erudio.exceptions.ExceptionResponse
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
    @ExceptionHandler(br.com.erudio.exceptions.ResourceNotFoundException::class)
 fun ResourceNotFoundException(ex: Exception, request: WebRequest) : ResponseEntity<ExceptionResponse> {
    val execptionResponse = ExceptionResponse(
        Date(),
        ex.message,
        request.getDescription(false)
    )
     return ResponseEntity<ExceptionResponse>(execptionResponse, HttpStatus.NOT_FOUND)
 }
}