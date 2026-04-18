package com.quinielamundial.web

import com.quinielamundial.prediction.PredictionRequest
import com.quinielamundial.prediction.PredictionService
import com.quinielamundial.user.UserService
import jakarta.validation.Valid
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader

@Controller
class PredictionController(
    private val predictionService: PredictionService,
    private val userService: UserService
) {
    @PostMapping("/predictions")
    fun create(
        @Valid predictionRequest: PredictionRequest,
        bindingResult: BindingResult,
        authentication: Authentication,
        model: Model,
        @RequestHeader("HX-Request", required = false) htmxRequest: String?
    ): String {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "Datos inválidos")
            return if (htmxRequest != null) "fragments/predictionForm" else "redirect:/matches/${predictionRequest.matchId}"
        }

        val user = userService.findByEmail(authentication.name) ?: throw IllegalStateException("Usuario no encontrado")
        val prediction = predictionService.savePrediction(user, predictionRequest)
        model.addAttribute("prediction", prediction)

        return if (htmxRequest != null) {
            "fragments/predictionSaved"
        } else {
            "redirect:/matches/${predictionRequest.matchId}"
        }
    }

    @GetMapping("/predictions/history")
    fun history(authentication: Authentication, model: Model): String {
        val user = userService.findByEmail(authentication.name) ?: throw IllegalStateException("Usuario no encontrado")
        model.addAttribute("predictions", predictionService.findHistory(user))
        return "prediction/history"
    }
}
