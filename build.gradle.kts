buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin")
        classpath("com.android.tools.build:gradle")
    }
}

group = "de.masterthesis"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

plugins {
    kotlin("multiplatform").version(extra["kotlin.version"] as String)  apply false
    kotlin("jvm").version(extra["kotlin.version"] as String)  apply false
    kotlin("android").version(extra["kotlin.version"] as String)  apply false
    id("com.android.application").version(extra["agp.version"] as String)  apply false
    id("com.android.library").version(extra["agp.version"] as String)  apply false
    id("org.jetbrains.compose").version(extra["compose.version"] as String)  apply false
    application
}