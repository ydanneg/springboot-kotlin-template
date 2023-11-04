package com.ydanneg.springboot.service.web

import com.ydanneg.springboot.model.Model1
import kotlinx.coroutines.delay
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ModelController {

    @PostMapping("/model")
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun createModel(@RequestBody body: Model1): Model1 {
        delay(1000)
        return body
    }
}