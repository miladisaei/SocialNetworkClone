package com.miladisaei.socialnetworkclone.data.repository

import com.miladisaei.socialnetworkclone.data.db.PostDAO
import com.miladisaei.socialnetworkclone.data.model.Post
import com.miladisaei.socialnetworkclone.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostsRepositoryImpl
@Inject
constructor(
    private val postDAO: PostDAO
) : PostsRepository {

    override fun getPosts(page: Int, count: Int): Flow<List<Post>> {
        return postDAO.getPosts(
            count = count,
            offset = (count * (page - 1))
        )
    }

    override fun getSinglePost(postId: Int): Flow<Post> {
        return postDAO.getSinglePost(postId)
    }

    override suspend fun likePost(postId: Int) {
        postDAO.likePost(postId)
    }

    override suspend fun unlikePost(postId: Int) {
        postDAO.unlikePost(postId)
    }
}