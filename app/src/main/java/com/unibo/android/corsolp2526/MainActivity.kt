package com.unibo.android.corsolp2526
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.unibo.android.ui.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Questo comando dice all'app di disegnare il tuo navigatore!
        setContent {
            AppNavigation()
        }
    }
}
