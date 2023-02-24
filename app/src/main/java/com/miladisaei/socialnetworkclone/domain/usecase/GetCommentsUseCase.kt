package com.miladisaei.socialnetworkclone.domain.usecase

import com.miladisaei.socialnetworkclone.data.model.Comment
import com.miladisaei.socialnetworkclone.domain.repository.CommentsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCommentsUseCase
@Inject
constructor(
    private val commentsRepository: CommentsRepository
) {

    fun execute(postId: Int, count: Int, offset: Int): Flow<List<Comment>> {
        return commentsRepository.getComments(
            postId = postId,
            count = count,
            offset = offset
        )
    }
}