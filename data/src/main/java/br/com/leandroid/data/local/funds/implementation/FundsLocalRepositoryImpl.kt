package br.com.leandroid.data.local.funds.implementation

import br.com.leandroid.data.local.funds.repository.FundsLocalRepository
import br.com.leandroid.data.local.funds.store.LocalFundsStore
import br.com.leandroid.data.network.funds.entity.FundsEntity
import kotlinx.coroutines.runBlocking

class FundsLocalRepositoryImpl(private val localFundsStore: LocalFundsStore) : FundsLocalRepository {

    override fun get(search: String): List<FundsEntity> {
        return runBlocking {
            localFundsStore.get()
        }
    }

    override fun save(funds: FundsEntity?) {
        runBlocking {
            localFundsStore.add(funds)
        }
    }

    override fun update(funds: FundsEntity?) {
        runBlocking {
            localFundsStore.update(funds)
        }
    }

    override fun clearData() {
        runBlocking {
            localFundsStore.clearAll()
        }
    }
}