package com.sai.primary.internal.presentation.ui.primary

import androidx.lifecycle.ViewModel
import com.sai.primary.internal.domain.repo.PrimaryRepository
import javax.inject.Inject

internal class PrimaryViewModel @Inject constructor(
    private val repository: PrimaryRepository
): ViewModel() {
}