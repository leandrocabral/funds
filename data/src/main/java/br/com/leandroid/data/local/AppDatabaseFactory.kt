package br.com.leandroid.data.local

import android.content.Context
import androidx.room.Room

internal class AppDatabaseFactory {
    fun getInstance(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "local_database")
            .build()
    }
}