package com.example.featurearch.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ViewModelDemo() : ViewModel() {

    var counter = 0
    private var counterValue = MutableLiveData<Int>()

    fun incrementCounter() {
        counter++
        counterValue.value = counter
    }

    fun getCounterValue() = counterValue

}