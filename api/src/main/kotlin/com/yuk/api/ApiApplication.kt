package com.yuk.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.query.QueryLookupStrategy

@SpringBootApplication(
        scanBasePackages = ["com.yuk"]
)
@EntityScan(basePackages = ["com.yuk.repository"])
@EnableJpaRepositories(basePackages = ["com.yuk.repository"])
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}
