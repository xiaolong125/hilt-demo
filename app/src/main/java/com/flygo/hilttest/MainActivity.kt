package com.flygo.hilttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var iLoginService: ILoginService

    @Inject
    lateinit var data: Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iLoginService.login()
        Log.e("MainActivity",iLoginService.toString())

        Log.e("MainActivity","data:${data.value}")


    }
}