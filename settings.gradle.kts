pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }


    val kotlinVersion: String by settings
    val agpVersion: String by settings
    val composeVersion: String by settings

    plugins {
        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("jvm") version kotlinVersion apply false
        kotlin("android") version kotlinVersion apply false
        id("com.android.application") version agpVersion apply false
        id("com.android.library") version agpVersion apply false
        id("org.jetbrains.compose") version composeVersion apply false
    }
}
rootProject.name = "MyTask"


include(":shared")
include(":androidApp")
include(":desktopApp")

