package br.com.leandroid.funds.presentation.funds

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.leandroid.core.BaseViewModel
import br.com.leandroid.core.Resource
import br.com.leandroid.domain.model.FundsDomain
import br.com.leandroid.domain.usecase.FundsUseCase
import br.com.leandroid.domain.usecase.IFundsUseCase
import kotlinx.coroutines.launch
import java.util.*

class FundsViewModel(private val useCase: IFundsUseCase) : BaseViewModel() {

    val fundsList = MutableLiveData<Resource<List<FundsDomain>>>()
    var fundsItem: List<FundsDomain> = listOf()

    fun getFunds() {
        viewModelScope.launch {
            with(fundsList) {
                loading(true)
                try {
                    fundsItem = useCase.getFunds()
                    success(fundsItem)
                } catch (e: Exception) {
                    error(e)
                } finally {
                    loading(false)
                }
            }
        }
    }

    fun searchFunds(search: String?) {
        search?.let {
            if (it.isEmpty()) {
                fundsList.success(fundsItem)
            } else {
                fundsList.success(
                    fundsItem.filter {
                        it.name.lowercase(Locale.ROOT)
                            .contains(search.lowercase(Locale.ROOT))
                    }
                )
            }
        }
    }
}