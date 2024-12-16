package com.sample.primary.internal.data.remote.api

import com.sample.primary.internal.data.remote.model.Comment
import retrofit2.http.GET
import retrofit2.http.Path

internal interface PrimaryApi {

    @GET("/posts/{postId}/comments")
    suspend fun getPostComments(
        @Path("postId") postId: Int
    ): List<Comment>
}