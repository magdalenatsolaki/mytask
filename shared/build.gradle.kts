@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.openapi.generator)
}

group = "de.masterthesis"
version = "1.0-SNAPSHOT"

kotlin {
    android()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting
        val androidMain by getting {
            dependencies {
                api(libs.android.core.ktx)
                api(libs.android.appcompat)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    namespace = "de.masterthesis.shared"
}
/**
 * doku quelle thesis: https://openapi-generator.tech/docs/generators/kotlin/
 * @todo muss in die Thesis:
 * bei der auswahl der configoptions muss auch kmm geachtet werden, da der generierte code auch für ios laufen muss und daher kotlin native supported sein muss
 */
val openapiSpecFile = "./openapi.json"

openApiGenerate {
    generatorName.set("kotlin")
    inputSpec.set(openapiSpecFile)
    //outputDir.set("$buildDir/generated")
    configFile.set("./api-config.json")
}

openApiValidate {
    inputSpec.set(openapiSpecFile)
}