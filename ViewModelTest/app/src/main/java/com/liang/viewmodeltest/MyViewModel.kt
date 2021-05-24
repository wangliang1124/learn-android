package com.liang.viewmodeltest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var number = 0
    private var numberLiveData: MutableLiveData<Int> = MutableLiveData<Int>().also {
        it.value = 0
    }

    fun getNumber(): MutableLiveData<Int> {
        return numberLiveData
    }

    fun addNumber() {
        numberLiveData.value = numberLiveData.value?.plus(1)
    }

    fun minusNumber() {
        numberLiveData.value = numberLiveData.value?.minus(1)
    }

}