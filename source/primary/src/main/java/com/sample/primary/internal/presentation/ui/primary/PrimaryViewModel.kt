package com.sample.primary.internal.presentation.ui.primary

import androidx.lifecycle.ViewModel
import com.sample.primary.internal.domain.repo.PrimaryRepository
import javax.inject.Inject

//@HiltViewModel
internal class PrimaryViewModel @Inject constructor(
    private val repository: PrimaryRepository
): ViewModel() {
}