package com.sai.sample.di.modules

import com.sai.sample.core.di.dispatchers.Dispatcher
import com.sai.sample.core.di.dispatchers.SampleDispatchers
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
object InjectorProviderModule {

    @Provides
    @Singleton
    @Dispatcher(dispatcher = SampleDispatchers.MAIN)
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @Singleton
    @Dispatcher(dispatcher = SampleDispatchers.IO)
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    @Dispatcher(dispatcher = SampleDispatchers.DEFAULT)
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}