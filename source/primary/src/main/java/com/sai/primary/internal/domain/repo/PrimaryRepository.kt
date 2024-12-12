package com.sai.primary.internal.domain.repo

import com.sai.primary.internal.data.remote.model.Comment

internal interface PrimaryRepository {

    suspend fun getPostComments(postId: Int): List<Comment>
}