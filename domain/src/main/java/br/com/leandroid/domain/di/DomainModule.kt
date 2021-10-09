package br.com.leandroid.domain.di

import br.com.leandroid.domain.usecase.FundsUseCase
import org.koin.dsl.module

val domainModule = module {

    single {
        FundsUseCase(get())
    }
}