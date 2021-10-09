package br.com.leandroid.funds.presentation.funds

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.leandroid.core.observeResource
import br.com.leandroid.funds.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class FundsActivity : AppCompatActivity() {

    private val viewModel by viewModel<FundsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.funds_activity)
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.getFunds()

        viewModel.fundsList.observeResource(this,
            onSuccess = {

            }, onError = {

            }, onLoading = {

            })
    }
}