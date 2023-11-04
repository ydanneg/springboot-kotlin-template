plugins {
    alias(myLibs.plugins.kotlin.jvm)
    alias(myLibs.plugins.kotlin.serialization)
    `java-library`
}

dependencies {
    api(myLibs.kotlinx.serialization.json)
}