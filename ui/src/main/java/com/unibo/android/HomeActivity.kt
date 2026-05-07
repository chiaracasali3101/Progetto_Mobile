package com.unibo.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.unibo.android.ui.databinding.ActivityHomeBinding
import com.unibo.android.fragments.HomeFragment
import com.unibo.android.fragments.SettingsFragment

class HomeActivity : androidx.appcompat.app.AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Set the content view using the generated binding class
        binding = ActivityHomeBinding.inflate(_root_ide_package_.android.app.Activity.getLayoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_home)

        val dataValue = _root_ide_package_.android.app.Activity.getIntent.getStringExtra(
            _root_ide_package_.com.unibo.android.splashActivityFakeDataKey
        )
        Log.d("HomeActivityTest", "Dato ricevuto da SPLASH: $dataValue")

        _root_ide_package_.androidx.fragment.app.FragmentActivity.getSupportFragmentManager.commit {
            add(
                R.id.fragmentContainerView,
                _root_ide_package_.com.unibo.android.fragments.HomeFragment.Companion.newInstance(
                    idProduct = dataValue ?: "default_product_id"
                )
            )
            addToBackStack("home_fragment")
        }

        binding.btnSettings.setOnClickListener {
            //findViewById<Button>(R.id.btnSettings).setOnClickListener {
            _root_ide_package_.androidx.fragment.app.FragmentActivity.getSupportFragmentManager.commit {
                replace(
                    R.id.fragmentContainerView,
                    _root_ide_package_.com.unibo.android.fragments.SettingsFragment()
                )
                addToBackStack("settings_fragment")
            }
        }
    }



    private fun setResultsForSplash() {
        val data = Intent()
        data.putExtra(
            _root_ide_package_.com.unibo.android.homeActivityResultMessageKey,
            "Grazie per aver visualizzato la home!"
        )
        _root_ide_package_.android.app.Activity.setResult(RESULT_OK, data)
        _root_ide_package_.android.app.Activity.finish()
    }
}