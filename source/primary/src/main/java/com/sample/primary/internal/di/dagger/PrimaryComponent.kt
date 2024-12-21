package com.sample.primary.internal.di.dagger

import android.content.Context
import androidx.navigation.NavController
import com.sai.sample.core.di.MainInjector
import com.sample.primary.internal.di.dagger.dependencies.PrimaryDependencies
import com.sample.primary.internal.di.dagger.injector.PrimaryInjector
import com.sample.primary.internal.di.dagger.modules.PrimaryProviderModule
import com.sample.primary.internal.di.dagger.modules.PrimaryBindModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        PrimaryProviderModule::class,
        PrimaryBindModule::class
    ],
    dependencies = [MainInjector::class, PrimaryDependencies::class]
)
internal interface PrimaryComponent: PrimaryInjector {

    @Component.Factory
    interface Factory {
        fun build(
            @BindsInstance context: Context,
            @BindsInstance navController: NavController,
            mainInjector: MainInjector,
            primaryDependencies: PrimaryDependencies
        ): PrimaryComponent
    }

    companion object {
        fun build(
            context: Context,
            navController: NavController,
            primaryDependencies: PrimaryDependencies
        ) = DaggerPrimaryComponent.factory().build(
            context = context,
            navController = navController,
            mainInjector = MainInjector.instance,
            primaryDependencies = primaryDependencies
        )
    }
}