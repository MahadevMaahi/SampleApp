package com.sai.sample.di

import android.content.Context
import com.sai.sample.application.SampleApp
import com.sai.sample.core.di.MainInjector
import com.sai.sample.di.modules.InjectorBindModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        InjectorBindModule::class,
        InjectorBindModule::class
    ],
    dependencies = []
)
interface AppComponent: MainInjector, AppLevelDependency {

    @Component.Factory
    interface Factory {
        fun build(
            @BindsInstance appContext: Context
        ) : AppComponent
    }

    companion object {
        fun build(
            appContext: Context
        ): AppComponent {
            val appComponent = DaggerAppComponent.factory().build(
                appContext = appContext
            )
            MainInjector.setMainInjector(appComponent)
            return appComponent
        }
    }

    fun inject(app: SampleApp)
}