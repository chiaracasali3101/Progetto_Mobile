package com.unibo.android.corsolp2526

import android.app.Application
import com.unibo.android.data.di.RepositoryProviderImpl

class CustomApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        UseCasesProvider.setup(
            repositoryProvider = RepositoryProviderImpl()
        )
    }
}