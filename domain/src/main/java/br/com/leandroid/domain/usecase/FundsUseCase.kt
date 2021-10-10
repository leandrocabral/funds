package br.com.leandroid.domain.usecase

import br.com.leandroid.data.network.funds.repository.FundsRepository
import br.com.leandroid.domain.model.FundsDomain

class FundsUseCase(private val remoteRepository: FundsRepository) {

    suspend fun getFunds(): List<FundsDomain> {
        return FundsDomain.convertToDomainList(remoteRepository.getFunds())
    }
}