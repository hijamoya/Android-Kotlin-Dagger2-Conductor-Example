package com.hijamoya.example.dagger.injection

import com.bluelinelabs.conductor.Controller

import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.Multibinds

@Module
abstract class ConductorInjectionModule private constructor() {

    @Multibinds abstract fun controllerInjectorFactories(): Map<Class<out Controller>,
            AndroidInjector.Factory<out Controller>>

    @Multibinds abstract fun controllerInjectorFactoriesWithStringKeys(): Map<String,
            AndroidInjector.Factory<out Controller>>
}
