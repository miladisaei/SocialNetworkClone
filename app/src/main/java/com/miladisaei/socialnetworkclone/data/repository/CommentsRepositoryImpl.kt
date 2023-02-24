package com.miladisaei.socialnetworkclone.data.repository

import com.miladisaei.socialnetworkclone.data.db.CommentDAO
import com.miladisaei.socialnetworkclone.data.db.PostDAO
import com.miladisaei.socialnetworkclone.data.model.Comment
import com.miladisaei.socialnetworkclone.domain.repository.CommentsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CommentsRepositoryImpl
@Inject
constructor(
    private val commentDAO: CommentDAO,
    private val postDAO: PostDAO
) : CommentsRepository {

    override fun getComments(postId: Int, count: Int, offset: Int): Flow<List<Comment>> {
        return commentDAO.getComments(
            postId = postId,
            count = count,
            offset = offset
        )
    }

    override suspend fun addComment(comment: Comment) {
        commentDAO.insertComment(comment)
        postDAO.addCommentCount(comment.postId)
    }
}