package com.toby.test.kotlinchat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class KotlinChatApplication

fun main(args: Array<String>) {
    runApplication<KotlinChatApplication>(*args)

}
