package com.flygo.hilttest

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class MainModule2 {

    //    @Named("value")
    @Provides
    fun testValue(): String {
        return "哈哈哈"
    }
}