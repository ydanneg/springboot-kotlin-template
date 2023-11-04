package com.ydanneg.springboot.service.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.http.codec.json.KotlinSerializationJsonDecoder
import org.springframework.http.codec.json.KotlinSerializationJsonEncoder
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer

@Configuration
@EnableWebFlux
class ApplicationConfig : WebFluxConfigurer {

    @Bean
    fun kotlinSerializationJsonEncoder(): KotlinSerializationJsonEncoder =
        KotlinSerializationJsonEncoder(Serializers.json)

    @Bean
    fun kotlinSerializationJsonDecoder(): KotlinSerializationJsonDecoder =
        KotlinSerializationJsonDecoder(Serializers.json)

    override fun configureHttpMessageCodecs(configurer: ServerCodecConfigurer) {
        configurer.defaultCodecs().kotlinSerializationJsonEncoder(kotlinSerializationJsonEncoder())
        configurer.defaultCodecs().kotlinSerializationJsonDecoder(kotlinSerializationJsonDecoder())
    }
}
