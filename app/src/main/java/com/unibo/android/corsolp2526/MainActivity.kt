package com.unibo.android.corsolp2526

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unibo.android.corsolp2526.data.repository.RepositoryProviderImpl
import com.unibo.android.ui.leaderboard.ClassificaScreen
import com.unibo.android.ui.leaderboard.ClassificaViewModel
import com.unibo.android.ui.leaderboard.ClassificaViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val factory = ClassificaViewModelFactory(RepositoryProviderImpl.getMovieRepository())

            val viewModel: ClassificaViewModel = viewModel(factory = factory)
            ClassificaScreen(viewModel = viewModel)
        }
    }
}