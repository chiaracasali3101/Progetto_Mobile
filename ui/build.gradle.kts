plugins {
    alias(libs.plugins.android.library)
    // 1. IL NUOVO PLUGIN PER KOTLIN 2.0 (ORA CON LA VERSIONE CORRETTA!)
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}

android {
    namespace = "com.unibo.android.ui"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    buildFeatures {
        viewBinding = true
        // ECCO LA MAGIA: Diciamo ad Android Studio di accendere Jetpack Compose!
        compose = true
    }

    // (Il blocco composeOptions che c'era prima è stato eliminato, come richiede Kotlin 2.0!)

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
    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.fragment.ktx)
    implementation(libs.androidx.recyclerview)

    // Versione vecchia
    // implementation("com.github.bumptech.glide:glide:5.0.5")
    // implementation ("androidx.cardview:cardview:1.0.0")
    implementation (libs.androidx.cardview)
    implementation(libs.glide)

    // --- I "DIZIONARI" DI COMPOSE ---
    val composeBom = platform("androidx.compose:compose-bom:2024.04.01")
    implementation(composeBom)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material:material-icons-extended")
    debugImplementation("androidx.compose.ui:ui-tooling")
    // ------------------------------------

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}