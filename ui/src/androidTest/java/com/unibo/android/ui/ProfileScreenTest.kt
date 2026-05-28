package com.unibo.android.ui // Verifica che il package sia lo stesso del file

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.assertIsDisplayed
import com.unibo.android.ui.screens.ProfileScreen // Importiamo la tua funzione
import org.junit.Rule
import org.junit.Test

class ProfileScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun profileScreen_showsUserInfo() {
        // 1. Carichiamo la tua schermata reale nel test
        composeTestRule.setContent {
            ProfileScreen()
        }

        // 2. Cerchiamo i testi REALI che hai scritto nel codice
        // Usiamo "Ana" o "IL TUO PROFILO" invece del generico "Nome"
        composeTestRule.onNodeWithText("IL TUO PROFILO").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ana").assertIsDisplayed()
        composeTestRule.onNodeWithText("ana.systemexpert@unibo.it").assertIsDisplayed()
    }
}