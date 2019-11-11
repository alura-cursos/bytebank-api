package br.com.alura.bytebank.model

import javax.persistence.Embeddable

@Embeddable
class Contact(
        val name: String,
        val accountNumber: Int
)