package com.hijamoya.example.ui

import com.hijamoya.example.dagger.injection.ActivityScope
import com.hijamoya.example.dagger.injection.ConductorInjectionModule
import com.hijamoya.example.dagger.injection.ControllerBindingModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MainActivityModule::class, ControllerBindingModule::class,
    ConductorInjectionModule::class])
@ActivityScope
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>
}
