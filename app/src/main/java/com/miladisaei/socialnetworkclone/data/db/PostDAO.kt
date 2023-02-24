package com.miladisaei.socialnetworkclone.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miladisaei.socialnetworkclone.data.model.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDAO {

    @Query("SELECT * FROM posts ORDER BY postId DESC LIMIT :count OFFSET :offset")
    fun getPosts(count: Int, offset: Int): Flow<List<Post>>

    @Query("SELECT * FROM posts WHERE postId = :postId")
    fun getSinglePost(postId: Int): Flow<Post>

    @Query("UPDATE posts SET isLiked = 1, likeCount = likeCount + 1 WHERE postId = :postId")
    suspend fun likePost(postId: Int)

    @Query("UPDATE posts SET isLiked = 0, likeCount = likeCount - 1 WHERE postId = :postId")
    suspend fun unlikePost(postId: Int)

    @Query("UPDATE posts SET commentCount = commentCount + 1 WHERE postId = :postId")
    suspend fun addCommentCount(postId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPostList(posts: List<Post>)
}