pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "multimodule"

include("domain")
include("repository")
include("api")
