package br.com.leandroid.funds.presentation.funds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.leandroid.funds.R
import br.com.leandroid.funds.presentation.util.observeResource
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