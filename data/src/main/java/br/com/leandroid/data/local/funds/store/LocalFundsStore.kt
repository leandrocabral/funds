package br.com.leandroid.data.local.funds.store

import br.com.leandroid.data.local.funds.dao.FundsDao
import br.com.leandroid.data.network.funds.entity.FundsEntity

class LocalFundsStore(private val fundsDao: FundsDao) {

    suspend fun get(): List<FundsEntity> {
        return fundsDao.getFunds()
    }

    suspend fun add(funds: FundsEntity?) {
        return fundsDao.insertFunds(funds)
    }

    suspend fun update(funds: FundsEntity?) {
        return fundsDao.updateFunds(funds)
    }

    suspend fun clearAll() {
        return fundsDao.deleteAll()
    }
}