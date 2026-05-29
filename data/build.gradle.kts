plugins {
    id("com.android.library")
    // Rimuovi id("org.jetbrains.kotlin.android") da qui!
}

android {
    namespace = "com.unibo.android.data"
    compileSdk = 36

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
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}