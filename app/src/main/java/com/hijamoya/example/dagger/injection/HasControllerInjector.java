package com.hijamoya.example.dagger.injection;

import com.bluelinelabs.conductor.Controller;

import dagger.android.DispatchingAndroidInjector;

public interface HasControllerInjector {

    DispatchingAndroidInjector<Controller> controllerInjector();

}
