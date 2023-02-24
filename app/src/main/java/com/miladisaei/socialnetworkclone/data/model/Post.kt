package com.miladisaei.socialnetworkclone.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey(autoGenerate = true)
    var postId: Int? = null,
    var username: String,
    var avatar: String,
    var postImage: String,
    var postCaption: String,
    var isLiked: Boolean,
    var likeCount: Int,
    var commentCount: Int,
    var time: String,
)
