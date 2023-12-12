package com.ydanneg.springboot.service.domain

import com.ydanneg.springboot.model.Model
import kotlinx.coroutines.delay
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ModelService {

    suspend fun getModel(modelId: String): Model {
        delay(1000)
        return Model(modelId, "Hello World")
    }

    suspend fun createModel(name: String): Model {
        delay(1000)
        return Model(UUID.randomUUID().toString(), name)
    }
}