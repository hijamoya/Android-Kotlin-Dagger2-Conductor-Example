package com.hijamoya.example

import com.hijamoya.example.dagger.injection.ActivityBindingModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActivityBindingModule::class,
    AndroidSupportInjectionModule::class])
internal interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<MyApplication>
}
