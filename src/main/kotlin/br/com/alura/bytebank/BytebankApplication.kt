package br.com.alura.bytebank

import br.com.alura.bytebank.service.ServiceInit
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BytebankApplication(
        private val service: ServiceInit) {

    @Bean
    fun run() = ApplicationRunner {
        service.saveDefaultFeatures()
    }

}

fun main(args: Array<String>) {
    runApplication<BytebankApplication>(*args)
}