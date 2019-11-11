package br.com.alura.bytebank.controller

import br.com.alura.bytebank.dto.FeatureRequest
import br.com.alura.bytebank.dto.FeatureResponse
import br.com.alura.bytebank.service.FeatureService
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

private const val invalidId = "invalid ID"

@RestController
@RequestMapping("/features")
class FeatureController(private val service: FeatureService) {

    @GetMapping
    fun all(): HttpEntity<List<FeatureResponse>> {
        return service.findAll()
                .map { FeatureResponse(it) }
                .let { ResponseEntity.ok(it) }
    }

    @GetMapping("/available")
    fun available(): HttpEntity<List<FeatureResponse>> {
        return service.available()
                .map { FeatureResponse(it) }
                .let { ResponseEntity.ok(it) }
    }

    @PostMapping
    fun save(@RequestBody request: FeatureRequest): HttpEntity<Any> {
        request.feature.let { featureReceived ->
            if(service.validate(featureReceived)){
                return service.save(request.feature)
                        .let { savedFeature ->
                            ResponseEntity.ok(FeatureResponse(savedFeature))
                        }
            }
            return ResponseEntity(invalidId, HttpStatus.BAD_REQUEST)
        }

    }

}