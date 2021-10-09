package br.com.leandroid.funds.presentation.funds

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.leandroid.core.BindingActivity
import br.com.leandroid.core.observeResource
import br.com.leandroid.funds.R
import br.com.leandroid.funds.databinding.FundsActivityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FundsActivity : BindingActivity<FundsActivityBinding>() {

    private val fundsAdapter by lazy {
        FundsAdapter {

        }
    }

    private val viewModel by viewModel<FundsViewModel>()

    override fun getLayoutId(): Int = R.layout.funds_activity

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setupRecyclerView()
        setupObserver()
        callFunds()
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
}