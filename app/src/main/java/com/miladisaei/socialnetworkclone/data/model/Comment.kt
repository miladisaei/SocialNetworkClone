package com.miladisaei.socialnetworkclone.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comments")
data class Comment(
    @PrimaryKey(autoGenerate = true)
    var commentId: Int? = null,
    var postId: Int,
    var username: String,
    var avatar: String,
    var message: String
)
