package com.sample.primary.internal.di.dagger.injector

import com.sample.primary.internal.presentation.ui.primary.PrimaryViewModel

internal interface PrimaryInjector {
    fun primaryViewModel(): PrimaryViewModel
}