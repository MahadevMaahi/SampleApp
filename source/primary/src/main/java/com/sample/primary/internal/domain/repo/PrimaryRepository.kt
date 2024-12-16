package com.sample.primary.internal.domain.repo

import com.sample.primary.internal.data.remote.model.Comment

internal interface PrimaryRepository {

    suspend fun getPostComments(postId: Int): List<Comment>
}