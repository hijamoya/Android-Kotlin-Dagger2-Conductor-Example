package com.hijamoya.example.dagger.injection

import com.bluelinelabs.conductor.Controller

import dagger.MapKey
import kotlin.reflect.KClass
import kotlin.annotation.Target

@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER)
annotation class ControllerKey(val value: KClass<out Controller>)