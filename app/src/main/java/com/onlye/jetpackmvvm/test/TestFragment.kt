package com.onlye.jetpackmvvm.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.onlye.jetpackmvvm.R
import com.onlye.jetpackmvvm.databinding.FragmentTestBinding

/**
 *@author onlye_lc
 *2023/4/25
 *@description
 **/
class TestFragment : Fragment() {

    private lateinit var dataBinding:FragmentTestBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         dataBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_test,
            container,
            false
        )

        return dataBinding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}