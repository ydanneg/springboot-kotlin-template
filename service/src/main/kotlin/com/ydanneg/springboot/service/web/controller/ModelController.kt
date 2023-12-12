package com.ydanneg.springboot.service.web.controller

import com.ydanneg.springboot.model.CreateModelRequest
import com.ydanneg.springboot.model.Model
import com.ydanneg.springboot.service.domain.ModelService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/models")
class ModelController(private val modelService: ModelService) {

    @GetMapping("/{modelId}")
    @ResponseStatus(HttpStatus.OK)
    suspend fun getModel(@PathVariable modelId: String): Model {
        return modelService.getModel(modelId)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun createModel(@RequestBody request: CreateModelRequest): Model {
        return modelService.createModel(request.name)
    }
}