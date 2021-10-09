package br.com.leandroid.data.network.funds.repository

import br.com.leandroid.data.network.funds.api.FundsApi
import br.com.leandroid.data.network.funds.entity.FundsEntity
import retrofit2.Retrofit

class FundsRepositoryImpl(private var retrofit: Retrofit) : FundsRepository {

    private val remoteFunds by lazy {
        retrofit.create(FundsApi::class.java)
    }

    override suspend fun getFunds(): List<FundsEntity>? {
        return remoteFunds.getFunds("").body()
    }
}