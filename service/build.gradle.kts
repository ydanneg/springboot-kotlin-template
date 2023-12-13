import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    alias(myLibs.plugins.kotlin.jvm)
    alias(myLibs.plugins.springboot)
    alias(myLibs.plugins.kotlin.serialization)
    alias(myLibs.plugins.kotlin.spring)
    alias(myLibs.plugins.springdoc.openapi)
//    alias(myLibs.plugins.graalvm)
    application
}

application {
    mainClass = "com.ydanneg.springboot.service.ApplicationKt"
}

dependencies {
    implementation(projects.model)

    val springBom = platform(SpringBootPlugin.BOM_COORDINATES)
    implementation(springBom)
    implementation(myLibs.springboot.starter.actuator)
    implementation(myLibs.springboot.starter.webflux)
    implementation(myLibs.springboot.starter.validation)
    developmentOnly("${myLibs.springboot.devtools.get().module}:${springBom.version}")
    implementation(myLibs.springboot.autoconfigure)
    implementation(myLibs.springdoc.openapi.webflux.ui)
    implementation(myLibs.kotlinx.coroutines.core)
    implementation(myLibs.kotlinx.coroutines.reactor)
    implementation(myLibs.kotlin.reflect)

    testImplementation(myLibs.kotest.assertions.core)
    testImplementation(myLibs.springboot.starter.test) {
        exclude(module = "mockito-core")
        exclude(module = "junit")
        exclude(module = "junit-vintage-engine")
        exclude(module = "slf4j-api")
    }
    testImplementation(myLibs.kotlin.test.junit5)
    testImplementation(myLibs.kotlinx.coroutines.core)
}