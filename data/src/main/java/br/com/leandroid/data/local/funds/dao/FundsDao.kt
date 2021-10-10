package br.com.leandroid.data.local.funds.dao

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.leandroid.data.local.TableNames
import br.com.leandroid.data.network.funds.entity.FundsEntity

interface FundsDao {

    @Query("SELECT * FROM ${TableNames.FUNDS_TABLE}")
    suspend fun getFunds(): List<FundsEntity>

    @Insert
    suspend fun insertFunds(funds: FundsEntity?)

    @Update
    suspend fun updateFunds(funds: FundsEntity?)

    @Query("DELETE FROM ${TableNames.FUNDS_TABLE}")
    suspend fun deleteAll()
}