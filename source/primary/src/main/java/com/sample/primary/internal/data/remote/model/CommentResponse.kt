package com.sample.primary.internal.data.remote.model

import com.google.gson.annotations.SerializedName

internal class CommentResponse(
    @SerializedName("postId")
    val postId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email:String,
    @SerializedName("body")
    val body: String
)