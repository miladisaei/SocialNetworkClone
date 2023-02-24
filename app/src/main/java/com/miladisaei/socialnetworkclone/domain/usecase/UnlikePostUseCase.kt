package com.miladisaei.socialnetworkclone.domain.usecase

import com.miladisaei.socialnetworkclone.domain.repository.PostsRepository
import javax.inject.Inject

class UnlikePostUseCase
@Inject
constructor(
    private val postsRepository: PostsRepository
) {

    suspend fun execute(postId: Int) {
        postsRepository.unlikePost(postId)
    }
}