package br.com.leandroid.funds.presentation.funds

import br.com.leandroid.core.BindingAdapter
import br.com.leandroid.domain.model.FundsDomain
import br.com.leandroid.funds.R
import br.com.leandroid.funds.databinding.ItemFundsBinding

class FundsAdapter(private val onClick: (FundsDomain) -> Unit) :
    BindingAdapter<FundsDomain, ItemFundsBinding>() {

    override fun getLayoutId(): Int = R.layout.item_funds

    override fun onBindViewHolder(binding: ItemFundsBinding, position: Int) {
        binding.run {
            item = getItem(position)

            cardfunds.setOnClickListener {
                onClick.invoke(getItem(position))
            }
        }
    }
}