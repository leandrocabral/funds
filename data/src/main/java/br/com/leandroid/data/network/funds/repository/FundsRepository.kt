package br.com.leandroid.data.network.funds.repository

import br.com.leandroid.data.network.funds.entity.FundsEntity

interface FundsRepository {
    suspend fun getFunds():  List<FundsEntity>?
}