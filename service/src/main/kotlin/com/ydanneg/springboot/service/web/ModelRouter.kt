package com.ydanneg.springboot.service.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class ModelRouter(
    private val modelHandler: ModelHandler
) {

    @Bean
    fun modelRoutes() = coRouter {
        "/v2/models".nest {
            GET("/{modelId}", modelHandler::handleGetModel)
            POST("", modelHandler::handleCreateModel)
        }
    }
}