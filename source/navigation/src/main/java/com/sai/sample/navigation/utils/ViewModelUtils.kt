package com.sai.sample.navigation.utils

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.savedstate.SavedStateRegistryOwner

@Composable
inline fun <reified T: ViewModel> viewModel(
    viewModelStoreOwner: ViewModelStoreOwner =
        checkNotNull(LocalViewModelStoreOwner.current) {
            "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
        },
    savedStateRegistryOwner: SavedStateRegistryOwner =
        checkNotNull(LocalSavedStateRegistryOwner.current) {
            "No SavedStateRegistryOwner was provided via LocalSavedStateRegistryOwner"
        },
    defaultArgs: Bundle? = null,
    crossinline factory: (SavedStateHandle) -> T
): T = androidx.lifecycle.viewmodel.compose.viewModel(
    viewModelStoreOwner = viewModelStoreOwner,
    factory = object : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, defaultArgs) {
        override fun <T : ViewModel> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            @Suppress("UNCHECKED_CAST")
            return factory(handle) as T
        }
    }
)