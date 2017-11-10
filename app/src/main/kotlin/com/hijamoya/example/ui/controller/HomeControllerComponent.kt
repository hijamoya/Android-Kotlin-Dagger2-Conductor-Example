package com.hijamoya.example.ui.controller

import com.hijamoya.example.dagger.injection.ControllerScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ControllerScope
@Subcomponent
interface HomeControllerComponent : AndroidInjector<HomeController> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomeController>()
}
