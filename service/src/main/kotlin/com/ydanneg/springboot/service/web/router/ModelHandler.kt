package com.ydanneg.springboot.service.web.router

import com.ydanneg.springboot.model.CreateModelRequest
import com.ydanneg.springboot.service.domain.ModelService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class ModelHandler(
    private val modelService: ModelService
) {

    suspend fun handleGetModel(request: ServerRequest): ServerResponse =
        modelService.getModel(request.pathVariable("modelId")).let {
            ServerResponse.ok().bodyValueAndAwait(it)
        }

    suspend fun handleCreateModel(request: ServerRequest): ServerResponse {
        val body = request.awaitBody(CreateModelRequest::class)
        return modelService.createModel(body.name).let {
            ServerResponse.status(201).bodyValueAndAwait(it)
        }
    }

}