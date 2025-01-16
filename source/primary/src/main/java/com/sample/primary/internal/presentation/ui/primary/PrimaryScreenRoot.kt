package com.sample.primary.internal.presentation.ui.primary

import androidx.compose.runtime.Composable
import com.sai.sample.common.ui.cream.components.loader.Loader

@Composable
internal fun PrimaryScreenRoot(
    viewModel: PrimaryViewModel
) {
    PrimaryScreen()
}

@Composable
private fun PrimaryScreen() {
    Loader()
}
