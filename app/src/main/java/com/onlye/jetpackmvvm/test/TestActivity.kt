package com.onlye.jetpackmvvm.test

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.onlye.mvvm.R

/**
 *@author onlye_lc
 *2023/4/23
 *@description
 **/
class TestActivity : AppCompatActivity() {

    val viewModel: TestViewModel by viewModels()

    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_test)

        val tv = findViewById<TextView>(R.id.textView)
        val tv2 = findViewById<TextView>(R.id.textView2)
        findViewById<Button>(R.id.button).setOnClickListener {
//            viewModel.data.value  = "${index++}"

//            viewModel.switchIntData.value = index++
            if (index%2 == 0)viewModel.switchData.value = "switchData" else viewModel.switchData2.value="switchData2"
            index++
        }

//        viewModel.data.observe(this){
//            tv.text = it
//        }
//
//        viewModel.mapData.observe(this){
//            tv2.text = it
//        }

        viewModel.switchMap.observe(this){
            tv.text = it
        }

        viewModel.switchData.value = "true"
        viewModel.switchData2.value = "false"
        viewModel.switchData3.value = "null"

        viewModel.fixData.observe(this){
            tv2.text = it
        }
        viewModel.s()

    }

}