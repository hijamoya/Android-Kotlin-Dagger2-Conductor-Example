package com.hijamoya.example.ui.controller

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.hijamoya.example.R
import com.hijamoya.example.dagger.ControllerScope
import com.hijamoya.example.dagger.component.CommonControllerComponent
import com.hijamoya.example.dagger.component.daggerComponent
import dagger.Component
import javax.inject.Inject

class HomeController: Controller() {

    @Component(dependencies = arrayOf(CommonControllerComponent::class))
    @ControllerScope(HomeController::class)
    interface ControllerComponent: CommonControllerComponent {

        fun inject(c: HomeController)

    }

    private val createComponent: ControllerComponent by lazy {
        val component = DaggerHomeController_ControllerComponent.builder()
                .commonControllerComponent(daggerComponent)
                .build()
        component.inject(this)
        component
    }

    @Inject lateinit var testStr: String
    @Inject lateinit var con: Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        createComponent
        return inflater.inflate(R.layout.controller_home, container, false)
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        Log.e("option", "come" + testStr + con)
    }

}