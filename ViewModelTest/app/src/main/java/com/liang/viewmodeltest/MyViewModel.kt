package com.liang.viewmodeltest

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel


class MyViewModel(handle: SavedStateHandle) : ViewModel() {
    private var _number = handle.getLiveData("my_number", 0)

    val number: LiveData<Int> = _number


    fun addNumber() {
        _number.value = _number.value?.plus(1)
    }


    fun minusNumber() {
        _number.value = _number.value?.minus(1)
    }

}