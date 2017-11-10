package com.hijamoya.example.dagger.injection;

import android.app.Activity;

import com.bluelinelabs.conductor.Controller;

import dagger.android.DispatchingAndroidInjector;
import dagger.internal.Preconditions;

public class ConductorInjection {

    public static void inject(Controller controller) {
        Preconditions.checkNotNull(controller, "controller");
        HasControllerInjector hasDispatchingControllerInjector = findControllerInjector(controller);
        DispatchingAndroidInjector<Controller> controllerInjector = hasDispatchingControllerInjector
                .controllerInjector();
        Preconditions.checkNotNull(controllerInjector, "%s.controllerInjector() returned null",
                hasDispatchingControllerInjector.getClass().getCanonicalName());
        controllerInjector.inject(controller);
    }

    private static HasControllerInjector findControllerInjector(Controller controller) {
        Controller parentController = controller;
        do {
            if ((parentController = parentController.getParentController()) == null) {
                Activity activity = controller.getActivity();
                if (activity instanceof HasControllerInjector) {
                    return (HasControllerInjector) activity;
                }
                if (activity.getApplication() instanceof HasControllerInjector) {
                    return (HasControllerInjector) activity.getApplication();
                }
                throw new IllegalArgumentException("No injector was found");
            }
        } while (!(parentController instanceof HasControllerInjector));
        return (HasControllerInjector) parentController;
    }

}
