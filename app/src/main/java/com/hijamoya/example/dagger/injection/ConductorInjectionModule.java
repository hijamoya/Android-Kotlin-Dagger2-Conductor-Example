package com.hijamoya.example.dagger.injection;

import com.bluelinelabs.conductor.Controller;

import java.util.Map;

import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.Multibinds;

@Module
public abstract class ConductorInjectionModule {

    private ConductorInjectionModule() {
    }

    @Multibinds
    abstract Map<Class<? extends Controller>,
            AndroidInjector.Factory<? extends Controller>> controllerInjectorFactories();

    @Multibinds
    abstract Map<String, AndroidInjector.Factory<? extends Controller>>
    controllerInjectorFactoriesWithStringKeys();

}
