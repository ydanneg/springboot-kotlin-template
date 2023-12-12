package com.ydanneg.springboot.service.web.router

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.coRouter

@Component
class ModelRouter(private val modelHandler: ModelHandler) {

    @Bean
    fun modelRoutes() = coRouter {
        "/v2/models".nest {
            GET("/{modelId}", modelHandler::handleGetModel)
            POST("", modelHandler::handleCreateModel)
        }
    }
}