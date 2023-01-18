pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }


    val kotlinVersion: String by settings
    val agpVersion: String by settings
    val composeVersion: String by settings
    val springBootVersion: String by settings
    val springDepMgmt: String by settings

    plugins {
        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("jvm") version kotlinVersion apply false
        kotlin("android") version kotlinVersion apply false
        kotlin("plugin.allopen") version kotlinVersion apply false
        kotlin("plugin.spring") version kotlinVersion apply false
        kotlin("plugin.jpa") version kotlinVersion apply false
        id("com.android.application") version agpVersion apply false
        id("com.android.library") version agpVersion apply false
        id("org.jetbrains.compose") version composeVersion apply false
        id("org.springframework.boot") version springBootVersion apply false
        id("io.spring.dependency-management") version springDepMgmt apply false
    }
}
rootProject.name = "MyTask"


include(":shared")
include(":androidApp")
include(":desktopApp")
include(":backendApi")

