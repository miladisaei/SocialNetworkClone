package com.miladisaei.socialnetworkclone.data.repository

import com.miladisaei.socialnetworkclone.data.model.Post
import com.miladisaei.socialnetworkclone.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakePostsRepositoryImpl : PostsRepository {

    private val postList = mutableListOf(
        Post(
            postId = 1,
            username = "user1",
            avatar = "https://ware.uncox.com/asset/profile/male/1.jpg",
            postImage = "https://picsum.photos/seed/1/300",
            postCaption = "dummy caption",
            isLiked = true,
            likeCount = 10,
            commentCount = 4,
            time = "8 hours ago"
        )
    )

    override fun getPosts(page: Int, count: Int): Flow<List<Post>> {
        return flowOf(postList)
    }

    override fun getSinglePost(postId: Int): Flow<Post> {
        return flowOf(postList[0])
    }

    override suspend fun likePost(postId: Int) {
    }

    override suspend fun unlikePost(postId: Int) {
    }
}