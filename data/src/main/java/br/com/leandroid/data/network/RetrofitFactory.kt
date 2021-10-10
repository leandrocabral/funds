package br.com.leandroid.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.Converter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

internal class RetrofitFactory {
    fun getRetrofitInstance(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        //val url = "https://s3.amazonaws.com/orama-media/json/"
        val url = "https://demo7441262.mockable.io/"

        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
    }
}