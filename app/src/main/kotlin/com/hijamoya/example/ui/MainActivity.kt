package com.hijamoya.example.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.hijamoya.example.R
import com.hijamoya.example.dagger.injection.HasControllerInjector
import com.hijamoya.example.ui.controller.HomeController
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasControllerInjector {

    @Inject lateinit var dispatchingControllerInjector: DispatchingAndroidInjector<Controller>

    private lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        router = Conductor.attachRouter(this, controller_container, savedInstanceState)
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(HomeController()))
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }

    override fun controllerInjector(): DispatchingAndroidInjector<Controller>? {
        return dispatchingControllerInjector
    }
}
