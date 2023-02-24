package com.miladisaei.socialnetworkclone.domain.usecase

import com.miladisaei.socialnetworkclone.data.model.Post
import com.miladisaei.socialnetworkclone.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSinglePostUseCase
@Inject
constructor(
    private val postsRepository: PostsRepository
) {

    fun execute(postId: Int): Flow<Post> {
        return postsRepository.getSinglePost(postId)
    }
}