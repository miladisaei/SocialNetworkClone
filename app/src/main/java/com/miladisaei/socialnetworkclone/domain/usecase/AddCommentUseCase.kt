package com.miladisaei.socialnetworkclone.domain.usecase

import com.miladisaei.socialnetworkclone.data.model.Comment
import com.miladisaei.socialnetworkclone.domain.repository.CommentsRepository
import com.miladisaei.socialnetworkclone.domain.repository.PostsRepository
import javax.inject.Inject

class AddCommentUseCase
@Inject
constructor(
    private val commentsRepository: CommentsRepository
) {

    suspend fun execute(comment: Comment) {
        commentsRepository.addComment(comment)
    }
}