package com.onlye.jetpackmvvm.test

import kotlin.math.sin

/**
 *@author onlye_lc
 *2023/4/27
 *@description
 **/
class TestParam<T> {

    var list = mutableListOf<String>()

//region test
    fun <B,A> param(t:T, list:List<B>,b:B):A?{

        sin(Math.PI)
        return null
    }
//end region
}

fun main() {
    Math.toDegrees(Math.PI)
}