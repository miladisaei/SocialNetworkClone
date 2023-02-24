package com.miladisaei.socialnetworkclone.domain.usecase

import com.miladisaei.socialnetworkclone.data.model.Post
import com.miladisaei.socialnetworkclone.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostsUseCase
@Inject
constructor(
    private val postsRepository: PostsRepository
) {

    fun execute(page: Int, count: Int): Flow<List<Post>> {
        return postsRepository.getPosts(
            page = page,
            count = count
        )
    }
}