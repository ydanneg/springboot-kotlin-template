import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(myLibs.plugins.kotlin.jvm) apply false
//    alias(myLibs.plugins.springboot)
//    alias(myLibs.plugins.kotlin.spring)
//    id("org.springframework.boot") version "3.1.5"
//    id("io.spring.dependency-management") version "1.1.3"
//    id("org.graalvm.buildtools.native") version "0.9.27"
//    kotlin("jvm") version "1.8.22"
//    kotlin("plugin.spring") version "1.8.22"
}

group = "com.ydanneg"
version = "0.0.1-SNAPSHOT"

//configurations {
//    compileOnly {
//        extendsFrom(configurations.annotationProcessor.get())
//    }
//}

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


//dependencyManagement {
//    imports {
//        mavenBom("com.google.cloud:spring-cloud-gcp-dependencies:${property("springCloudGcpVersion")}")
//        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//    }
//}
