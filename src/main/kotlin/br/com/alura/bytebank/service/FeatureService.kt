package br.com.alura.bytebank.service

import br.com.alura.bytebank.model.Feature
import br.com.alura.bytebank.repository.FeaturesRepository
import org.springframework.stereotype.Service

@Service
class FeatureService(
        private val repository: FeaturesRepository) {

    fun findAll() = repository.findAll().toList()

    fun save(feature: Feature) = repository.save(feature)

    fun available(): List<Feature> =
            repository.findAllByAvailable(true)

    fun validate(feature: Feature) = feature.id > 0

}