package br.com.alura.bytebank.model

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class PasswordValidator {

    @Value("\${user.password}")
    private lateinit var passwordApplication: String

    fun valida(password: String) = password == passwordApplication

}
