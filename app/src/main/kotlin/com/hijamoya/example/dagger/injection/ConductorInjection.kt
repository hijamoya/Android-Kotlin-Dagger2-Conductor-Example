package com.hijamoya.example.dagger.injection

import com.bluelinelabs.conductor.Controller
import dagger.internal.Preconditions

class ConductorInjection {

    companion object {
        fun inject(controller: Controller) {
            Preconditions.checkNotNull(controller, "controller")
            val hasDispatchingControllerInjector = findControllerInjector(controller)
            val controllerInjector = hasDispatchingControllerInjector
                    .controllerInjector()
            Preconditions.checkNotNull(controllerInjector,
                    "%s.controllerInjector() returned null",
                    hasDispatchingControllerInjector.javaClass.canonicalName)
            controllerInjector.inject(controller)
        }

        private fun findControllerInjector(controller: Controller): HasControllerInjector {
            var parentController: Controller? = controller
            do {
                parentController = parentController?.parentController
                if (parentController == null) {
                    val activity = controller.activity
                    if (activity is HasControllerInjector) {
                        return activity
                    }
                    if (activity!!.application is HasControllerInjector) {
                        return activity.application as HasControllerInjector
                    }
                    throw IllegalArgumentException("No injector was found")
                }
            } while (parentController !is HasControllerInjector)
            return parentController
        }
    }
}
