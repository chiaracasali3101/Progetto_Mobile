package com.unibo.android.corsolp2526

import android.app.Application
import androidx.room.Room
import com.unibo.android.data.local.FilmDatabase

class CustomApplication : Application() {

    companion object {
        lateinit var instance: CustomApplication
            private set
    }

    val database: FilmDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            FilmDatabase::class.java,
            "film_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}