package com.hijamoya.example.dagger.module

import com.hijamoya.example.dagger.CommonControllerScope
import dagger.Module
import dagger.Provides

@Module
class ControllerModule {

    @Provides
    @CommonControllerScope
    fun controllerString() = "inject!!"

}