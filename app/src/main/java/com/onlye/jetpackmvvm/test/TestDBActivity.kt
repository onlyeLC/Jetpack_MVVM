package com.onlye.jetpackmvvm.test

import android.os.Bundle
import android.service.autofill.FieldClassification.Match
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.onlye.jetpackmvvm.R
import com.onlye.jetpackmvvm.databinding.ActTestDbBinding
import java.lang.Math.random
import kotlin.math.round

/**
 *@author onlye_lc
 *2023/4/25
 *@description
 **/
open class TestDBActivity: AppCompatActivity() {

    val viewModel:TestViewModel by viewModels()
    lateinit var binding: ActTestDbBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.act_test_db)

        //集合LiveData
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.click = ProxyClick()


        initVmObserver()

        initView()

        initData()

    }

    private fun initData() {
        Math.toDegrees(Math.PI/2)
        Log.e("TAG", "initData: ${round(0.5)}")
        random()
    }

    private fun initView() {
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView,TestFragment()).commitAllowingStateLoss()
    }

    private fun initVmObserver() {
        viewModel.btnText.observe(this){

        }
        viewModel.tvText.observe(this){

        }
        viewModel.etText.observe(this){
            viewModel.tvText.value = it
        }
        viewModel.mvNum.observe(this){
            Log.e("TAG", "双向绑定事件: $it")
        }

    }

    @CallSuper
    protected fun test() {

    }

    inner class ProxyClick {

        fun start() {
            viewModel.btnText.value = "暂停"
        }

        fun upStart() {

        }

        fun add() {
            viewModel.mvNum.value = viewModel.mvNum.value?.plus(1)
        }
    }

    override fun onStop() {
        super.onStop()


    }
}