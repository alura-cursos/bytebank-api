package br.com.alura.bytebank.repository

import br.com.alura.bytebank.model.Transaction
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository : PagingAndSortingRepository<Transaction, String> {
    fun findAllByOrderByDateTimeAsc(): List<Transaction>
}
