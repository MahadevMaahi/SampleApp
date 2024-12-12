package com.sai.primary.internal.data.repo

import com.sai.primary.internal.data.remote.api.PrimaryApi
import com.sai.primary.internal.data.remote.model.Comment
import com.sai.primary.internal.domain.repo.PrimaryRepository
import javax.inject.Inject

internal class PrimaryRepositoryImpl @Inject constructor(
    private val primaryApi: PrimaryApi
): PrimaryRepository {
    override suspend fun getPostComments(postId: Int): List<Comment> {
        return primaryApi.getPostComments(postId = postId)
    }
}