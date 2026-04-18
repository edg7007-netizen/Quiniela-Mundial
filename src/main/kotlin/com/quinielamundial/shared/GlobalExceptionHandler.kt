package com.quinielamundial.shared

import com.quinielamundial.prediction.DuplicatePredictionException
import com.quinielamundial.prediction.PredictionClosedException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(PredictionClosedException::class, DuplicatePredictionException::class)
    fun handlePredictionErrors(ex: RuntimeException, request: HttpServletRequest, model: Model): Any {
        val wantsJson = request.requestURI.startsWith("/api/") ||
            (request.getHeader("Accept")?.contains("application/json") == true)

        return if (wantsJson) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(mapOf("error" to (ex.message ?: "Error de validación")))
        } else {
            model.addAttribute("errorMessage", ex.message ?: "Error de validación")
            "error/404"
        }
    }
}
