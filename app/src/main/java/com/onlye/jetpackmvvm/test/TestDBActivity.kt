package com.onlye.jetpackmvvm.test

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.onlye.jetpackmvvm.R
import com.onlye.jetpackmvvm.databinding.ActTestDbBinding

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
    }

    override fun onStop() {
        super.onStop()


    }
}