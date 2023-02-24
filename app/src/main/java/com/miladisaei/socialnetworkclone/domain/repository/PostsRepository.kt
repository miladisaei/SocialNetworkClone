package com.miladisaei.socialnetworkclone.domain.repository

import com.miladisaei.socialnetworkclone.data.model.Post
import kotlinx.coroutines.flow.Flow

interface PostsRepository {

    fun getPosts(page: Int, count: Int): Flow<List<Post>>
    fun getSinglePost(postId: Int): Flow<Post>
    suspend fun likePost(postId: Int)
    suspend fun unlikePost(postId: Int)
}