package com.miladisaei.socialnetworkclone.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miladisaei.socialnetworkclone.data.model.Comment
import kotlinx.coroutines.flow.Flow

@Dao
interface CommentDAO {

    @Query("SELECT * FROM comments WHERE postId = :postId OR postId = 0 ORDER BY commentId DESC LIMIT :count OFFSET :offset")
    fun getComments(postId: Int, count: Int, offset: Int): Flow<List<Comment>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(comment: Comment)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCommentList(comments: List<Comment>)
}