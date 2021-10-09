package br.com.leandroid.funds.presentation.di

import br.com.leandroid.funds.presentation.detailFunds.DetailFundsViewModel
import br.com.leandroid.funds.presentation.funds.FundsViewModel
import org.koin.dsl.module

val presentationModule = module {

    single {
        FundsViewModel(get())
    }

    single {
        DetailFundsViewModel()
    }

}
