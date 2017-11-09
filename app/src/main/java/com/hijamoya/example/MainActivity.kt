package com.hijamoya.example

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.hijamoya.example.dagger.component.ActivityComponent
import com.hijamoya.example.dagger.component.DaggerActivityComponent
import com.hijamoya.example.dagger.module.ActivityModule
import com.hijamoya.example.ui.controller.HomeController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var router: Router

    companion object {
        private var component: ActivityComponent? = null
        fun getComponent(c: Context): ActivityComponent {
            if (component == null) {
                component = DaggerActivityComponent
                        .builder()
                        .applicationComponent(MyApplication.getComponent(c.applicationContext))
                        .activityModule(ActivityModule(c.applicationContext))
                        .build()
            }
            return component!!
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getComponent(this).inject(this)
        setContentView(R.layout.activity_main)

        router = Conductor.attachRouter(this, controller_container, savedInstanceState)
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(HomeController()))
        }
    }

}
