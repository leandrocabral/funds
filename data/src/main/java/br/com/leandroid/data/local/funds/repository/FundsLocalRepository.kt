package br.com.leandroid.data.local.funds.repository

import br.com.leandroid.data.network.funds.entity.FundsEntity

interface FundsLocalRepository {
    fun get(search: String): List<FundsEntity>?
    fun save(funds: FundsEntity?)
    fun update(funds: FundsEntity?)
    fun clearData()
}