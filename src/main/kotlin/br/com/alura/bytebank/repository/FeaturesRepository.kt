package br.com.alura.bytebank.repository

import br.com.alura.bytebank.model.Feature
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface FeaturesRepository : PagingAndSortingRepository<Feature, String> {
    fun findAllByAvailable(available: Boolean): List<Feature>
}