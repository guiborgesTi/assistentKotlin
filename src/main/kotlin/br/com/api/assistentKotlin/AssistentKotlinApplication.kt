package br.com.api.assistentKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class AssistentKotlinApplication{}

fun main(args: Array<String>) {
	runApplication<AssistentKotlinApplication>(*args)
}