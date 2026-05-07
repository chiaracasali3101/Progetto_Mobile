plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    // Questo è l'indirizzo unico del modulo domain
    namespace = "com.unibo.android.domain"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // Qui solitamente non serve quasi nulla, lasciamo il minimo
    implementation(libs.androidx.core.ktx)
    implementation(libs.room.ktx)
}