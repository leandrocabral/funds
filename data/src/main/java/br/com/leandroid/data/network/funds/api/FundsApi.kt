package br.com.leandroid.data.network.funds.api

import br.com.leandroid.data.network.funds.entity.FundsEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FundsApi {

    @GET("fund_detail_full.json")
    suspend fun getFunds(
        @Query("serializer") serializer: String
    ): Response<List<FundsEntity>>
}