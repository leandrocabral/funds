package br.com.leandroid.funds.presentation.funds

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.leandroid.domain.model.FundsDomain
import br.com.leandroid.domain.usecase.FundsUseCase
import br.com.leandroid.funds.presentation.util.BaseViewModel
import br.com.leandroid.funds.presentation.util.Resource
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