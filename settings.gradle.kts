pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "MyTask"

include(":shared")
include(":androidApp")
include(":backendApi")
