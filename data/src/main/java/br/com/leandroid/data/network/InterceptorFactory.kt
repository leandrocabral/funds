package br.com.leandroid.data.network

import br.com.leandroid.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

internal class InterceptorFactory() {
    fun getInterceptors(): List<Interceptor> {
        return arrayListOf(
            getOkHttpLoggingInterceptorInstance()
        )
    }

    private fun getOkHttpLoggingInterceptorInstance(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            }
    }
}