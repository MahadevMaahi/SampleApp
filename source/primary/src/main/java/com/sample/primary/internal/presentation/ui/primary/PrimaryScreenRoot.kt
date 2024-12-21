package com.sample.primary.internal.presentation.ui.primary

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun PrimaryScreenRoot(
    viewModel: PrimaryViewModel
) {
    PrimaryScreen(
        name = viewModel.toString()
    )
}

@Composable
private fun PrimaryScreen(
    name: String
) {
    Text(
        modifier = Modifier,
        text = "Hello $name"
    )
}
