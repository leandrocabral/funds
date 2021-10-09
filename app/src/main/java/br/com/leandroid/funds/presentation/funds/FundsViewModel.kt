package br.com.leandroid.funds.presentation.funds

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.leandroid.core.BaseViewModel
import br.com.leandroid.core.Resource
import br.com.leandroid.domain.model.FundsDomain
import br.com.leandroid.domain.usecase.FundsUseCase
import kotlinx.coroutines.launch

class FundsViewModel(private val useCase: FundsUseCase) : BaseViewModel() {

    val fundsList = MutableLiveData<Resource<List<FundsDomain>>>()

    fun getFunds() {
        viewModelScope.launch {
            with(fundsList) {
                loading(true)
                try {
                    success(useCase.getFunds())
                } catch (e: Exception) {
                    error(e)
                } finally {
                    loading(false)
                }
            }
        }
    }
}