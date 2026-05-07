plugins {
    // Usiamo le stringhe dirette, così non può sbagliare
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.unibo.android.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
    }
}

dependencies {
    // Importante: 'data' deve poter usare le classi di 'domain'
    implementation(project(":domain"))

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)
}