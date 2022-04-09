package com.yuk.api

import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springdoc.core.SpringDocUtils
import org.springframework.boot.info.BuildProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebSession
import java.util.*

@Configuration
class OpenApiConfig {

    init {
        SpringDocUtils.getConfig()
            .addResponseWrapperToIgnore(Optional::class.java)
            .addRequestWrapperToIgnore(
                WebSession::class.java,
                ServerHttpRequest::class.java,
                ServerHttpResponse::class.java,
                ServerWebExchange::class.java
            )
    }
    @Bean
    fun openAPI(): OpenAPI {
        val info = Info()
            .title("")
            .version("")
            .description(
                """
                """
            )
            .contact(
                Contact()
                    .name("")
                    .url("")
            )

        return OpenAPI()
            .components(addSecurity())
            .info(info)
    }

    private fun addSecurity(): Components {
        var components = Components()

        components = components.addSecuritySchemes(
            "name",
            SecurityScheme().name("name").type(SecurityScheme.Type.APIKEY).`in`(
                SecurityScheme.In.HEADER)
        )

        return components
    }
}
