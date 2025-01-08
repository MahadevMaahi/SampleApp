package com.sai.sample.core.di.dispatchers

import javax.inject.Qualifier

@Qualifier
annotation class Dispatcher(val dispatcher: SampleDispatchers)

enum class SampleDispatchers {
    IO,
    MAIN,
    DEFAULT
}
