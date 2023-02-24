package com.miladisaei.socialnetworkclone.domain.repository

import com.miladisaei.socialnetworkclone.data.model.Comment
import kotlinx.coroutines.flow.Flow

interface CommentsRepository {

    fun getComments(postId: Int, count: Int, offset: Int): Flow<List<Comment>>
    suspend fun addComment(comment: Comment)
}