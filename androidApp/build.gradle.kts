@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.android.application)
}

group = "de.masterthesis"
version = "1.0-SNAPSHOT"

kotlin {
    android()
    sourceSets {
        val androidMain by getting {
            dependencies {
                dependencies {
                    implementation(project(":shared"))
                    implementation(libs.bundles.androidAppImpl)
                    implementation(libs.activity.compose)
                    implementation(libs.compose.material3)
                    implementation(libs.runtime.livedata)
                    api(compose.runtime)
                    api(compose.foundation)
                }
            }
        }
    }
}

android {
    namespace = "de.masterthesis.android"
    compileSdk = 33

    defaultConfig {
        applicationId = "de.masterthesis.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtensionVersion.get()
    }
}