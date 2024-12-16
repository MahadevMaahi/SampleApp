package com.sample.primary.internal.presentation.ui.primary

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PrimaryScreenRoot() {
    val viewModel: PrimaryViewModel = hiltViewModel()

}

@Composable
internal fun PrimaryScreen() {

}
