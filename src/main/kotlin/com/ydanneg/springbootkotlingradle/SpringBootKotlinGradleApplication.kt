package com.ydanneg.springbootkotlingradle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinGradleApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinGradleApplication>(*args)
}
