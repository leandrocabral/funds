package br.com.leandroid.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.leandroid.data.local.funds.dao.FundsDao
import br.com.leandroid.data.network.funds.entity.FundsEntity

@Database(entities = [FundsEntity::class], version = 1, exportSchema = false)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun fundsDao(): FundsDao
}