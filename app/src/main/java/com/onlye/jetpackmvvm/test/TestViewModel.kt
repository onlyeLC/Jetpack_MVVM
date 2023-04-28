package com.onlye.jetpackmvvm.test

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 *@author onlye_lc
 *2023/4/23
 *@description
 **/
class TestViewModel : ViewModel() {

    /**
     * databinding
     */
    val btnText = MutableLiveData<String>()
    val tvText = MutableLiveData<String>()
    val etText = MutableLiveData<String>()
    val mvNum = MutableLiveData<Int>()

    /**
     * livedata
     */
    val data = MutableLiveData<String>()
    val mapData = Transformations.map(data) {
        "转变后结果$it"
    }

    val switchIntData = MutableLiveData<Int>()

    val switchData = MutableLiveData<String>()
    val switchData2 = MutableLiveData<String>()
    val switchData3 = MutableLiveData<String>()
    val switchMap = Transformations.switchMap(
        switchIntData
    ) { input ->
        when (input%3) {
            0->switchData
            1->switchData2
            else -> switchData3
        }
    }

    val fixData = MediatorLiveData<String>()

    fun s(){
        fixData.apply {
            addSource(switchData){
                fixData.value = it
            }
            addSource(switchData2){
                fixData.value = it
            }
        }

    }


}