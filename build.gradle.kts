buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
        classpath("com.android.tools.build:gradle:7.4.0")
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

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.multiplatform).apply(false)
    alias(libs.plugins.kotlin.jvm).apply(false)
    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.kotlin.plugin.allopen).apply(false)
    alias(libs.plugins.kotlin.plugin.jpa).apply(false)
    alias(libs.plugins.kotlin.plugin.spring).apply(false)
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.compose).apply(false)
    alias(libs.plugins.springboot).apply(false)
    alias(libs.plugins.spring.depmngt).apply(false)
    alias(libs.plugins.spring.openapi.gradleplugin).apply(false)
}
println("")

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}