import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.6" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    id("org.jlleitschuh.gradle.ktlint") version "10.2.1" apply false
    kotlin("plugin.spring") version "1.6.10" apply false
    kotlin("plugin.jpa") version "1.6.10" apply false
    kotlin("plugin.allopen") version "1.6.10"
    kotlin("jvm") version "1.6.10"
    kotlin("kapt") version "1.6.10"
    java
    idea
}

group = "com.yuk"
version = "1.0"

allprojects {
    group = "com.yuk.multimodule"

    repositories {
        mavenCentral()
    }
}

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "idea")
    apply(plugin = "java")

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }

    java.sourceCompatibility = JavaVersion.VERSION_11

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.getByName<Test>("test") {
        useJUnitPlatform()
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "7.4.2"
}

project(":domain") {
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.jetbrains.kotlin.plugin.allopen")

    allOpen {
        annotation("javax.persistence.Entity")
        annotation("javax.persistence.MappedSuperclass")
        annotation("javax.persistence.Embeddable")
    }

    dependencies {
        //https://github.com/vladmihalcea/hibernate-types
        implementation("com.vladmihalcea:hibernate-types-55:2.15.1") {
            exclude(group = "com.fasterxml.jackson.module")
        }

        implementation("org.springframework.boot:spring-boot-autoconfigure:2.6.6")
        implementation("jakarta.persistence:jakarta.persistence-api:2.2.3")
    }
}

project(":repository") {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.jetbrains.kotlin.kapt")

    dependencies {
        api(project(":domain"))

        api("org.springframework.boot:spring-boot-starter-data-jpa")

        kapt("com.querydsl:querydsl-apt:5.0.0:jpa")

        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("com.querydsl:querydsl-jpa:5.0.0")

        //runtimeOnly("mysql:mysql-connector-java")
        runtimeOnly("com.h2database:h2")

        testImplementation("org.springframework.boot:spring-boot-starter-test")  {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        }
    }

    defaultTasks("jar")

    tasks.getByName("bootJar") {
        enabled = false
    }

    idea {
        module {
            val srcPath = "src"
            val kaptMain = file("build/generated/source/kapt/$srcPath")
            sourceDirs.add(kaptMain)
            generatedSourceDirs.add(kaptMain)
        }
    }
}

project(":api") {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.kapt")

    dependencies {
        api(project(":repository"))

        kapt("org.springframework.boot:spring-boot-configuration-processor")

        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-webflux")
        implementation("org.springframework.boot:spring-boot-starter-actuator")
        implementation("org.springframework.boot:spring-boot-starter-validation")

        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
        implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

        implementation("org.springdoc:springdoc-openapi-kotlin:1.6.7")
        implementation("org.springdoc:springdoc-openapi-ui:1.6.7")

        testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")

        testImplementation("org.springframework.boot:spring-boot-starter-test")  {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        }
    }
}
