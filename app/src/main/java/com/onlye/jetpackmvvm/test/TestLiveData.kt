package com.onlye.jetpackmvvm.test

import androidx.lifecycle.LiveData

/**
 *@author onlye_lc
 *2023/4/23
 *@description
 **/
class TestLiveData<T>: LiveData<T>() {
    override fun onActive() {
        super.onActive()
    }

    override fun onInactive() {
        super.onInactive()
    }
}