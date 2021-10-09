package br.com.leandroid.data

import br.com.leandroid.data.network.InterceptorFactory
import br.com.leandroid.data.network.OkHttpFactory
import br.com.leandroid.data.network.RetrofitFactory
import br.com.leandroid.data.network.funds.repository.FundsRepository
import br.com.leandroid.data.network.funds.repository.FundsRepositoryImpl
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.datatype.threetenbp.ThreeTenModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

val dataModule = module {
    single {
        RetrofitFactory().getRetrofitInstance(get(), get(), get())
    }

    single {
        OkHttpFactory().getOkHttpInstance(get())
    }

    single {
        InterceptorFactory()
    }

    single {
        RxJava2CallAdapterFactory.create()
    }

    single<Converter.Factory> {
        val objectMapper = jacksonObjectMapper()
        objectMapper.propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        objectMapper.registerModule(ThreeTenModule())
        JacksonConverterFactory.create(objectMapper)
    }

    single<FundsRepository> {
        FundsRepositoryImpl(get())
    }
}
