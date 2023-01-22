@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.compose)
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

group = "de.masterthesis"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":shared"))
    implementation(libs.activity.compose)
    implementation(libs.compose.material3)
    api(compose.runtime)
    api(compose.foundation)
    //api(compose.material)
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "de.masterthesis.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    namespace = "de.masterthesis.android"


    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

}