package com.unibo.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.unibo.android.corsolp2526.presentation.RepositoryProviderImpl
import com.unibo.android.domain.di.UseCasesProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repositoryReale = RepositoryProviderImpl.filmRepository

        UseCasesProvider.initialize(repository = repositoryReale)
    }
}