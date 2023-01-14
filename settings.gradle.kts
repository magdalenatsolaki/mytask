pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    
}
rootProject.name = "Demo"


include(":mytask-ui-common")
include(":mytask-ui-android")
include(":mytask-ui-desktop")

