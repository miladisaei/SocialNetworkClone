package com.miladisaei.socialnetworkclone.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.miladisaei.socialnetworkclone.data.model.Comment
import com.miladisaei.socialnetworkclone.data.model.Post

@Database(
    entities = [Post::class, Comment::class],
    version = 1,
    exportSchema = false
)
abstract class SocialNetworkDatabase : RoomDatabase() {
    abstract fun getPostDAO(): PostDAO
    abstract fun getCommentDAO(): CommentDAO
}