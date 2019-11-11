package br.com.alura.bytebank.service

import br.com.alura.bytebank.model.Feature
import org.springframework.stereotype.Service

@Service
class ServiceInit(
        private val featureService: FeatureService
) {

    fun saveDefaultFeatures() {
        featureService.save(Feature(
                1,
                available = true
        ))
        featureService.save(Feature(
                2,
                available = true
        ))
    }

}