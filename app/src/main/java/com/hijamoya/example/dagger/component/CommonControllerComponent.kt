package com.hijamoya.example.dagger.component

import com.hijamoya.example.dagger.CommonControllerScope
import dagger.Component
import com.hijamoya.example.dagger.module.ControllerModule

@Component(modules = arrayOf(ControllerModule::class),
        dependencies = arrayOf(ActivityComponent::class))
@CommonControllerScope
interface CommonControllerComponent: ActivityComponent {

    fun testStr(): String

}