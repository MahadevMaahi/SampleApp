package com.sample.primary.internal.domain.usecase

import com.sai.sample.core.coroutines.resultOf
import com.sai.sample.core.di.dispatchers.Dispatcher
import com.sai.sample.core.di.dispatchers.SampleDispatchers
import com.sample.primary.internal.domain.mapper.CommentMapper
import com.sample.primary.internal.domain.repo.PrimaryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class GetPostCommentsUseCase @Inject constructor(
    private val primaryRepository: PrimaryRepository,
    private val commentsMapper: CommentMapper,
    @Dispatcher(dispatcher = SampleDispatchers.IO)
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(postId: Int) = resultOf {
        withContext(dispatcher) {
            commentsMapper(
                primaryRepository.getPostComments(
                    postId = postId
                )
            )
        }
    }
}
