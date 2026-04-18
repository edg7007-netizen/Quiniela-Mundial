package com.quinielamundial.api.v1

import com.quinielamundial.prediction.PredictionRequest
import com.quinielamundial.prediction.PredictionService
import com.quinielamundial.user.UserService
import jakarta.validation.Valid
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/predictions")
class PredictionRestController(
    private val predictionService: PredictionService,
    private val userService: UserService
) {
    @PostMapping
    fun create(@Valid @RequestBody request: PredictionRequest, authentication: Authentication) =
        predictionService.savePrediction(
            userService.findByEmail(authentication.name) ?: throw IllegalStateException("Usuario no encontrado"),
            request
        )
}
