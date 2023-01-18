plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

group = "de.masterthesis"
version = "1.0-SNAPSHOT"

dependencies {
    val androidxActivity = project.ext.get("androidxActivity")

    implementation(project(":shared"))
    implementation("androidx.activity:activity-compose:$androidxActivity")
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
}