package com.unibo.android.corsolp2526.presentation

import android.app.Application
import com.unibo.android.data.di.RepositoryProviderImpl
import com.unibo.android.domain.di.UseCasesProvider

class CustomApplication: Application(){
    override fun onCreate() {
        super.onCreate()

        useCasesProvider.setup(
            repositoryProvider = RepositoryProviderImpl()
        )
    }
}