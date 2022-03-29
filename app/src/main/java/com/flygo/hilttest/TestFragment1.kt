package com.flygo.hilttest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flygo.hilttest.databinding.FragmentTest1Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * fragment 测试类1
 */
@AndroidEntryPoint
class TestFragment1: Fragment() {

    @Inject
    lateinit var iLoginService: ILoginService

    lateinit var binding: FragmentTest1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTest1Binding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text1.setOnClickListener {
            Log.e("TestFragment1",iLoginService.toString())
            iLoginService.login()
        }
    }

}