plugins {
    // Plugin Kotlin puro (niente Android qui)
    id("org.jetbrains.kotlin.jvm")
}

android {
    namespace = "com.unibo.android.domain"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // Solo librerie Kotlin/Java standard, nessuna libreria Android

    // JUnit per i test unitari della logica di business
    testImplementation(libs.junit)

    // ECCO LA MODIFICA: ho rimosso i "//" in modo che la libreria venga scaricata!
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}