package com.liang.viewmodeltest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private var _number = MutableLiveData(0)

    val number: LiveData<Int> = _number

    fun addNumber() {
        _number.value = _number.value?.plus(1)
    }

    fun minusNumber() {
        _number.value = _number.value?.minus(1)
    }

}