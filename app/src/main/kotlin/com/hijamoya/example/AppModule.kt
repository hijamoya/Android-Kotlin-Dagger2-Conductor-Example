package com.hijamoya.example

import android.content.Context
import android.telephony.TelephonyManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides @Singleton fun telephonyManager(app: MyApplication): TelephonyManager {
        return app.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    }
}