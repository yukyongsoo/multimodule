package com.yuk.domain

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration

@Configuration(proxyBeanMethods = false)
@EntityScan
internal open class EntityAutoConfig
