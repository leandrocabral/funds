package br.com.leandroid.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    protected fun <T> MutableLiveData<Resource<T>>.success(data: T?) {
        postValue(Resource.success(data))
    }

    protected fun <T> MutableLiveData<Resource<T>>.error(e: Throwable?) {
        value = Resource.error(e)
    }

    protected fun <T> MutableLiveData<Resource<T>>.loading(boolean: Boolean) {
        value = Resource.loading(boolean)
    }
}