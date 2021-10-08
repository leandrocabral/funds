package br.com.leandroid.data

import br.com.leandroid.data.network.InterceptorFactory
import br.com.leandroid.data.network.OkHttpFactory
import br.com.leandroid.data.network.RetrofitFactory
import org.koin.dsl.module
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

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
}
