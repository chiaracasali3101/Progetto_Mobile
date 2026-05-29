package com.unibo.android.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.unibo.android.ui.databinding.ActivityHomeBinding
import com.unibo.android.ui.fragments.HomeFragment
import com.unibo.android.ui.fragments.SettingsFragment

// ⚠️ NOTA: Questa Activity è deprecata (Legacy). Ora usiamo MainActivity + Compose.
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataValue = intent.getStringExtra(splashActivityFakeDataKey)
        Log.d("HomeActivityTest", "Dato ricevuto da SPLASH: $dataValue")

        supportFragmentManager.commit {
            add(
                R.id.fragmentContainerView,
                HomeFragment.Companion.newInstance(
                    idProduct = dataValue ?: "default_product_id"
                )
            )
            addToBackStack("home_fragment")
        }

        /* COMMENTATO PER EVITARE ERRORI DI COMPILAZIONE (CustomButton spostato in _legacy)
        binding.btnSettings.setOnClickListener {
            supportFragmentManager.commit {
                replace(
                    R.id.fragmentContainerView,
                    SettingsFragment()
                )
                addToBackStack("settings_fragment")
            }
        }
        */
    }

    private fun setResultsForSplash() {
        val data = Intent()
        data.putExtra(
            homeActivityResultMessageKey,
            "Grazie per aver visualizzato la home!"
        )
        setResult(RESULT_OK, data)
        finish()
    }
}