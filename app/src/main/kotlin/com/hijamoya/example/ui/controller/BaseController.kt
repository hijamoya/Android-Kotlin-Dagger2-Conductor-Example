package com.hijamoya.example.ui.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.hijamoya.example.dagger.injection.ConductorInjection
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.*

abstract class BaseController(args: Bundle?) : Controller(args), LayoutContainer {

    override val containerView: View?
        get() = contentView

    private var injected = false
    private lateinit var contentView: View

    protected abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup): View

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        try {
            ConductorInjection.inject(this)
            injected = true
        } catch (ignored: Throwable) {
            // delay injection until onCreateView
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        if (!injected) {
            ConductorInjection.inject(this)
            injected = true
        }
        contentView = inflateView(inflater, container)
        onViewBound(contentView)
        return contentView
    }

    open fun onViewBound(view: View) {
        // for override
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        clearFindViewByIdCache()
    }
}