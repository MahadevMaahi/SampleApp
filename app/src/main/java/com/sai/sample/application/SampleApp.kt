package com.sai.sample.application

import android.app.Application
import com.sai.sample.core.di.AppDependencyProvider
import com.sai.sample.di.AppComponent

//@HiltAndroidApp
class SampleApp: Application(), AppDependencyProvider {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.build(appContext = applicationContext)
        appComponent.inject(this)
    }

    override fun <T> getAppLevelDependency(): T {
        return appComponent as T
    }

}