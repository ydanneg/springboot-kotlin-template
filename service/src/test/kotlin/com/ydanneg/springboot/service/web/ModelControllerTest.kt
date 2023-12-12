package com.ydanneg.springboot.service.web

import com.ydanneg.springboot.model.Model
import com.ydanneg.springboot.test.SpringBootIntegrationTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters
import java.util.UUID
import kotlin.test.Test

@SpringBootIntegrationTest
class ModelControllerTest {

    @Autowired
    private lateinit var client: WebTestClient

    @Test
    fun test() {
        val body = Model(UUID.randomUUID().toString(), UUID.randomUUID().toString())

        client.post()
            .uri("/model")
            .accept(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(body))
            .exchange()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectStatus().isCreated
            .expectBody(Model::class.java)
            .isEqualTo(body)
    }

}