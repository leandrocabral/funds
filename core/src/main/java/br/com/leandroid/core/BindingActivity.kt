package br.com.leandroid.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BindingActivity<T : ViewDataBinding> : AppCompatActivity() {

    @LayoutRes
    abstract fun getLayoutId(): Int

    lateinit var binding: T

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        DataBindingUtil.setContentView<T>(this, getLayoutId()).run {
            binding = this
        }
    }
}