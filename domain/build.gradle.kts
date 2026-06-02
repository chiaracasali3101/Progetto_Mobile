plugins {
    // Plugin Kotlin puro (niente Android qui)
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    // Solo librerie Kotlin/Java standard, nessuna libreria Android

    // JUnit per i test unitari della logica di business
    testImplementation(libs.junit)

    // ECCO LA MODIFICA: ho rimosso i "//" in modo che la libreria venga scaricata!
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}

