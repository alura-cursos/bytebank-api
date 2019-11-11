package br.com.alura.bytebank.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Feature(
        @Id
        val id: Long = 0,
        val available: Boolean = false
)