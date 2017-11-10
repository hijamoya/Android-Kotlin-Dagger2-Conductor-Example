package com.hijamoya.example.dagger.injection;

import android.app.Activity;

import com.hijamoya.example.ui.MainActivity;
import com.hijamoya.example.ui.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainActivityComponent.class})
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindYourActivityInjectorFactory(MainActivityComponent.Builder builder);

}
