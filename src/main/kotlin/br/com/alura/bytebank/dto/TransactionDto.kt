package br.com.alura.bytebank.dto

import br.com.alura.bytebank.model.Contact
import br.com.alura.bytebank.model.Transaction
import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

open class TransactionRequest(
        id: String?,
        contact: Contact,
        value: BigDecimal) {

    val transaction: Transaction = Transaction(
            id = id ?: UUID.randomUUID().toString(),
            contact = contact,
            value = value
    )

}

class TransactionResponse(
        transaction: Transaction,
        val id: String = transaction.id,
        val value: BigDecimal = transaction.value,
        val contact: Contact = transaction.contact,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        val dateTime: LocalDateTime = transaction.dateTime
)

