package com.sai.sample.core.di

import com.sai.sample.core.di.dispatchers.Dispatcher
import com.sai.sample.core.di.dispatchers.SampleDispatchers
import kotlinx.coroutines.CoroutineDispatcher

interface MainInjector {

    @Dispatcher(dispatcher = SampleDispatchers.MAIN)
    fun getMainDispatcher(): CoroutineDispatcher

    @Dispatcher(dispatcher = SampleDispatchers.IO)
    fun getIODispatcher(): CoroutineDispatcher

    @Dispatcher(dispatcher = SampleDispatchers.DEFAULT)
    fun getDefaultDispatcher(): CoroutineDispatcher

    companion object {
        private var _instance: MainInjector? = null

        @JvmStatic
        val instance: MainInjector
            get() = _instance
                ?: throw IllegalStateException("MainInjector.instance not initialized!")

        @JvmStatic
        fun setMainInjector(mainInjector: MainInjector) {
            if (_instance == null) {
                _instance = mainInjector
            }
        }
    }
}