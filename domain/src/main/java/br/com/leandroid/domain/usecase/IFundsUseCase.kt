package br.com.leandroid.domain.usecase

import br.com.leandroid.domain.model.FundsDomain

interface IFundsUseCase {
    suspend fun getFunds(): List<FundsDomain>
}