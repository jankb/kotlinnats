package net.polvott.kotlinnats

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinnatsApplication

fun main(args: Array<String>) {
	runApplication<KotlinnatsApplication>(*args)
}
