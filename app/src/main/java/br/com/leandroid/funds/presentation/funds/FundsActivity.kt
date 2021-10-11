package br.com.leandroid.funds.presentation.funds

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.leandroid.core.BindingActivity
import br.com.leandroid.core.observeResource
import br.com.leandroid.domain.model.FundsDomain
import br.com.leandroid.funds.R
import br.com.leandroid.funds.databinding.FundsActivityBinding
import br.com.leandroid.funds.presentation.detailFunds.DetailFundsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FundsActivity : BindingActivity<FundsActivityBinding>() {

    private val fundsAdapter by lazy {
        FundsAdapter {
            startDetailFundsActivity(it)
        }
    }

    private val viewModel by viewModel<FundsViewModel>()

    override fun getLayoutId(): Int = R.layout.funds_activity

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setupRecyclerView()
        setupObserver()
        callFunds()
        searchFunds()
    }

    private fun callFunds() {
        viewModel.getFunds()
    }

    private fun setupObserver() {
        viewModel.fundsList.observeResource(this,
            onSuccess = {
                if (it.isNotEmpty()) {
                    fundsAdapter.submitList(it)
                }
            }, onError = {

            }, onLoading = {
                if (it) {
                    binding.fundsProgressbar.visibility = View.VISIBLE
                } else {
                    binding.fundsProgressbar.visibility = View.INVISIBLE
                }
            }
        )
    }

    private fun setupRecyclerView() {
        binding.fundsRecyclerview.apply {
            adapter = fundsAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun searchFunds() {
        binding.fundsToolbarHeader
            .editSearch?.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    filterFunds()
                }
                false
            }
    }

    private fun filterFunds() {
        val funds = binding.fundsToolbarHeader.editSearch?.text.toString()
        viewModel.searchFunds(funds)
        fundsAdapter.notifyDataSetChanged()
    }

    private fun startDetailFundsActivity(fundsDomain: FundsDomain) {
        val intent = Intent(this, DetailFundsActivity::class.java)
        intent.putExtra(DETAIL_FUNDS_KEY, fundsDomain)
        startActivity(intent)
    }

    companion object {
        const val DETAIL_FUNDS_KEY = "DETAIL_FUNDS"
    }
}