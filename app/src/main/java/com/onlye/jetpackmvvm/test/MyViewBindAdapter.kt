package com.onlye.jetpackmvvm.test

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

/**
 *@author onlye_lc
 *2023/4/26
 *@description
 **/
object MyViewBindAdapter {


    @BindingAdapter("num")
    @JvmStatic fun setNum(view: MyView, num: Int) {
        if (view.num == num) {
            return
        }
        view.num = num
    }


    @InverseBindingAdapter(attribute = "num")
    @JvmStatic fun getNum(view: MyView): Int {
        return view.num
    }


    @JvmStatic
    @BindingAdapter("numAttrChanged")
    fun setNumChangeListener(view: MyView, attrChange: InverseBindingListener) {
        view.mOnNumChangeListener = object : MyView.OnNumChangeListener {
            override fun onNumChanged() {
                attrChange.onChange()
            }
        }
    }
}