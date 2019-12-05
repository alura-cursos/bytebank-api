package br.com.alura.bytebank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BytebankApplication

fun main(args: Array<String>) {
    runApplication<BytebankApplication>(*args)
}