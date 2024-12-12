package com.sai.primary.internal.data.remote.model

import com.google.gson.annotations.SerializedName

internal class Comment(
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