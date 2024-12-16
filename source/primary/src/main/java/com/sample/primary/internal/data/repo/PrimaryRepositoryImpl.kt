package com.sample.primary.internal.data.repo

import com.sample.primary.internal.data.remote.api.PrimaryApi
import com.sample.primary.internal.data.remote.model.Comment
import com.sample.primary.internal.domain.repo.PrimaryRepository
import javax.inject.Inject

internal class PrimaryRepositoryImpl @Inject constructor(
    private val primaryApi: PrimaryApi
): PrimaryRepository {
    override suspend fun getPostComments(postId: Int): List<Comment> {
        return primaryApi.getPostComments(postId = postId)
    }
}