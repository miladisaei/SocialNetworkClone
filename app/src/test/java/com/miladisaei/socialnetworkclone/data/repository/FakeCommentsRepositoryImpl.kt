package com.miladisaei.socialnetworkclone.data.repository

import com.miladisaei.socialnetworkclone.data.model.Comment
import com.miladisaei.socialnetworkclone.data.model.Post
import com.miladisaei.socialnetworkclone.domain.repository.CommentsRepository
import com.miladisaei.socialnetworkclone.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeCommentsRepositoryImpl : CommentsRepository {

    private val commentList = mutableListOf(
        Comment(
            commentId = 1,
            postId = 2,
            username = "user1",
            avatar = "https://ware.uncox.com/asset/profile/male/1.jpg",
            message = "This is a Test Message"
        )
    )

    override fun getComments(postId: Int, count: Int, offset: Int): Flow<List<Comment>> {
        return if (postId == 2)
            flowOf(commentList)
        else
            flowOf(emptyList())
    }

    override suspend fun addComment(comment: Comment) {
    }

}