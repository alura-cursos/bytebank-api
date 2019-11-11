package br.com.alura.bytebank.controller

import br.com.alura.bytebank.dto.TransactionRequest
import br.com.alura.bytebank.dto.TransactionResponse
import br.com.alura.bytebank.model.PasswordValidator
import br.com.alura.bytebank.service.TransactionService
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

private const val transactionExists = "transaction already exists"
private const val authenticationFail = "authentication failed"

@RestController
@RequestMapping("/transactions")
class TransactionController(
        private val service: TransactionService,
        private val validator: PasswordValidator) {

    @GetMapping
    fun all(): HttpEntity<List<TransactionResponse>> {
        return service.findAll().map { TransactionResponse(it) }
                .let { response ->
                    ResponseEntity.ok(response)
                }
    }

    @PostMapping
    fun save(@RequestBody request: TransactionRequest,
             @RequestHeader("password") password: String): HttpEntity<Any> {
        if (validator.valida(password)) {
            request.transaction.let { transactionReceived ->
                if (service.exists(transactionReceived.id)) {
                    return ResponseEntity(transactionExists, HttpStatus.CONFLICT)
                }
                return service.save(transactionReceived)
                        .let { savedTransaction ->
                            ResponseEntity.ok(savedTransaction)
                        }
            }
        }
        return ResponseEntity(authenticationFail, HttpStatus.UNAUTHORIZED)
    }

}