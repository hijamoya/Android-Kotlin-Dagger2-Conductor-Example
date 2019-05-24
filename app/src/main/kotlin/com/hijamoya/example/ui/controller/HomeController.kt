package com.hijamoya.example.ui.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hijamoya.example.R
import com.hijamoya.example.dagger.injection.ActivityScope
import kotlinx.android.synthetic.main.controller_home.*
import javax.inject.Inject

class HomeController : BaseController(args = null) {

    @Inject @ActivityScope lateinit var name: String

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View =
            inflater.inflate(R.layout.controller_home, container, false)

    override fun onViewBound(view: View) {
        text.text = name
    }
}