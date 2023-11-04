package com.ydanneg.springboot.test

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.UseMainMethod.ALWAYS
import java.lang.annotation.Inherited

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Inherited
@SpringBootTest(useMainMethod = ALWAYS)
@AutoConfigureWebTestClient
annotation class SpringBootIntegrationTest {
}