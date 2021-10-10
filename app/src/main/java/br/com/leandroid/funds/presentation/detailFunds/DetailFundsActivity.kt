package br.com.leandroid.funds.presentation.detailFunds

import android.os.Bundle
import br.com.leandroid.core.BindingActivity
import br.com.leandroid.domain.model.FundsDomain
import br.com.leandroid.funds.R
import br.com.leandroid.funds.databinding.DetailFundsActivityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFundsActivity : BindingActivity<DetailFundsActivityBinding>() {

    private var fundsDomain: FundsDomain? = null

    private val viewModel by viewModel<DetailFundsViewModel>()

    override fun getLayoutId(): Int = R.layout.detail_funds_activity

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        fundsDomain = intent.getParcelableExtra(DETAIL_FUNDS_KEY)
        fundsDomain?.let {
            binding.item = it
        }
        setupObserver()
    }

    private fun setupObserver() {
        binding.detailFundsToolbarHeader
            .arrowBack?.setOnClickListener {
                finish()
            }
    }

    companion object {
        const val DETAIL_FUNDS_KEY = "DETAIL_FUNDS"
    }
}