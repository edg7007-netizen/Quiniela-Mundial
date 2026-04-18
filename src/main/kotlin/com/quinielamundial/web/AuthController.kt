package com.quinielamundial.web

import com.quinielamundial.user.UserService
import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class AuthController(
    private val userService: UserService
) {
    @GetMapping("/login")
    fun loginPage(): String = "auth/login"

    @GetMapping("/register")
    fun registerPage(model: Model): String {
        model.addAttribute("registerForm", RegisterForm())
        return "auth/register"
    }

    @PostMapping("/register")
    fun register(
        @Valid @ModelAttribute("registerForm") registerForm: RegisterForm,
        bindingResult: BindingResult,
        model: Model
    ): String {
        if (bindingResult.hasErrors()) {
            return "auth/register"
        }

        return try {
            userService.registerLocalUser(registerForm.name, registerForm.email, registerForm.password)
            "redirect:/login?registered"
        } catch (_: IllegalArgumentException) {
            model.addAttribute("errorMessage", "El correo ya está registrado")
            "auth/register"
        }
    }
}

data class RegisterForm(
    @field:NotBlank
    val name: String = "",
    @field:Email
    @field:NotBlank
    val email: String = "",
    @field:NotBlank
    @field:Size(min = 8)
    val password: String = ""
)
