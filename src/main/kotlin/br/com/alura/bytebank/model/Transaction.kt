package br.com.alura.bytebank.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Transaction(
        @Id
        val id: String = UUID.randomUUID().toString(),
        val value: BigDecimal,
        @Embedded
        val contact: Contact,
        val dateTime: LocalDateTime = LocalDateTime.now()
)
