package com.hijamoya.example.dagger.component

import com.bluelinelabs.conductor.Controller
import com.hijamoya.example.dagger.module.ControllerModule
import com.hijamoya.example.MainActivity

val Controller.daggerComponent: CommonControllerComponent
    get() = DaggerCommonControllerComponent
            .builder()
            .activityComponent(MainActivity.getComponent(applicationContext!!))
            .controllerModule(ControllerModule())
            .build()