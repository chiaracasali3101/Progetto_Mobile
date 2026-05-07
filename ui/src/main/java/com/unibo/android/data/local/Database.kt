package com.unibo.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FilmEntity::class], version = 1)
abstract class FilmDatabase : RoomDatabase() {
    abstract fun filmDao(): com.unibo.android.data.local.FilmDao
}