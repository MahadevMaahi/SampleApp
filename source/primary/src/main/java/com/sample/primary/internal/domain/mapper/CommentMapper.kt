package com.sample.primary.internal.domain.mapper

import com.sample.primary.internal.data.remote.model.CommentResponse
import com.sample.primary.internal.domain.model.Comment
import javax.inject.Inject

internal class CommentMapper @Inject constructor() {
    suspend operator fun invoke(comment: List<CommentResponse>): List<Comment> = buildList {
        comment.forEach {
            with(it) {
                add(
                    Comment(
                        id = id,
                        postId = postId,
                        name = name,
                        email = email,
                        body = body
                    )
                )
            }
        }
    }
}