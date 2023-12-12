package com.ydanneg.springboot.service.web

import com.ydanneg.springboot.model.CreateModelRequest
import com.ydanneg.springboot.model.Model
import com.ydanneg.springboot.test.SpringBootIntegrationTest
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
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
        val request = CreateModelRequest(UUID.randomUUID().toString())

        val body = client.post()
            .uri("/v1/models")
            .accept(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(request))
            .exchange()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectStatus().isCreated
            .expectBody(Model::class.java)
            .returnResult().responseBody

        body shouldNotBe null
        with(body!!) {
            name shouldBe request.name
        }
    }

}