package com.hijamoya.example.dagger.module

import android.content.Context
import com.hijamoya.example.dagger.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val applicationContext: Context) {

  @Singleton
  @ApplicationContext
  @Provides
  fun provideApplicationContext() = applicationContext

}