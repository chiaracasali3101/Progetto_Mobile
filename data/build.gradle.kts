plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.unibo.android.data"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 31
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

// Configura Kotlin usando il blocco kotlin globale
kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(project(":domain"))

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
}