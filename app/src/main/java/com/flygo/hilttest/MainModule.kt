package com.flygo.hilttest

import android.content.Context
import android.widget.Toast
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.internal.modules.ApplicationContextModule
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * 告知 Hilt 如何提供某些类型的实例
 */
@Module
//绑定module的生命周期,例如绑定了fragment生命周期就不能在Activity里使用
//@InstallIn(ActivityComponent::class)
@InstallIn(SingletonComponent::class)
abstract class MainModule {

    /**
     * 2种方式，第一种Binds 必须是抽象类
     * impl: LoginServiceImpl 是返回类型的实现类
     */
    @Binds
    //加上这个表示在Activity生命周期内只有一个实例,不加会有多个实例对象
//    @ActivityScoped
    @Singleton
    abstract fun bindService(impl: LoginServiceImpl):ILoginService


//    /**
//     * 第二种，Provides 返回具体的实现类
//     */
//    @Provides
//    fun bindService():ILoginService{
//        return LoginServiceImpl()
//    }

}



interface ILoginService{
    fun login()
}


/**
 * 加上Inject的constructor才可以把参数注入进来
 */
//加上了Singleton表示全局单例
//@Singleton
class LoginServiceImpl @Inject constructor(@ApplicationContext val context: Context):ILoginService{
    override fun login() {
        Toast.makeText(context,"LoginServiceImpl login",Toast.LENGTH_LONG).show()
    }

}

