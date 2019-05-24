package com.hijamoya.example.dagger.injection

import com.bluelinelabs.conductor.Controller
import dagger.android.DispatchingAndroidInjector

interface HasControllerInjector {

    fun controllerInjector(): DispatchingAndroidInjector<Controller>
}