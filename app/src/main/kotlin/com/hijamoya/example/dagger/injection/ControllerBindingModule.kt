package com.hijamoya.example.dagger.injection

import com.bluelinelabs.conductor.Controller
import com.hijamoya.example.ui.controller.HomeController
import com.hijamoya.example.ui.controller.HomeControllerComponent

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [HomeControllerComponent::class])
abstract class ControllerBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(HomeController::class)
    abstract fun bindHomeControllerInjectorFactory(builder: HomeControllerComponent.Builder):
            AndroidInjector.Factory<out Controller>
}
