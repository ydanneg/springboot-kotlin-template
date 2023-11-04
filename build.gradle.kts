import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(myLibs.plugins.kotlin.jvm) apply false
}

group = "com.ydanneg"
version = "0.0.1-SNAPSHOT"

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

subprojects {
    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_17.toString()
                javaParameters = true
                freeCompilerArgs += "-Xjsr305=strict"
            }
        }
        withType<JavaCompile> {
            sourceCompatibility = JavaVersion.VERSION_17.toString()
            targetCompatibility = JavaVersion.VERSION_17.toString()
        }
        withType<Test> {
            useJUnitPlatform()
            testLogging {
                showStandardStreams = true
                exceptionFormat = TestExceptionFormat.FULL
                events("skipped", "failed")
            }
        }
    }
}
