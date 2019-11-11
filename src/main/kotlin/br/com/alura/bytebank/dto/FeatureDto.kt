package br.com.alura.bytebank.dto

import br.com.alura.bytebank.model.Feature

class FeatureRequest(
        val id: Long,
        val available: Boolean,
        val feature: Feature = Feature(
                id = id,
                available = available
        )
)

class FeatureResponse(feature: Feature,
                      val id: Long = feature.id)