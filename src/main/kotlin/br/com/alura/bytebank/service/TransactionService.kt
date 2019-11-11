package br.com.alura.bytebank.service

import br.com.alura.bytebank.model.Transaction
import br.com.alura.bytebank.repository.TransactionRepository
import org.springframework.stereotype.Service

@Service
class TransactionService(private val repository: TransactionRepository) {

    fun findAll() = repository.findAllByOrderByDateTimeAsc()

    fun save(transaction: Transaction) = repository.save(transaction)

    fun exists(id: String) = repository.existsById(id)

}