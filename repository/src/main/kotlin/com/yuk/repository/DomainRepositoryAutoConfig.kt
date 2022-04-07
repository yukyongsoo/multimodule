package com.yuk.repository

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration(proxyBeanMethods = false)
@EntityScan
@EnableJpaRepositories
@ComponentScan
class DomainRepositoryAutoConfig