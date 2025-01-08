package com.sample.primary.internal.presentation.ui.primary

import androidx.lifecycle.ViewModel
import com.sai.sample.core.coroutines.launch
import com.sample.primary.internal.domain.usecase.GetPostCommentsUseCase
import javax.inject.Inject

//@HiltViewModel
internal class PrimaryViewModel @Inject constructor(
    private val getPostCommentsUseCase: GetPostCommentsUseCase
): ViewModel() {

    init {
        getPostComments()
    }

    private fun getPostComments() {
        launch { getPostCommentsUseCase(postId = 1) }
    }

}