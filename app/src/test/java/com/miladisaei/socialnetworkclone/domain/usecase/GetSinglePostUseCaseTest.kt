package com.miladisaei.socialnetworkclone.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.miladisaei.socialnetworkclone.data.repository.FakePostsRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetSinglePostUseCaseTest {

    private lateinit var getSinglePostUseCase: GetSinglePostUseCase
    private lateinit var fakePostRepository: FakePostsRepositoryImpl

    @Before
    fun setUp() {
        fakePostRepository = FakePostsRepositoryImpl()
        getSinglePostUseCase = GetSinglePostUseCase(fakePostRepository)
    }

    @Test
    fun getSinglePost_success() = runBlocking {
        getSinglePostUseCase.execute(
            postId = 1
        ).collect {
            assertThat(it.postId).isEqualTo(1)
            assertThat(it.username).isEqualTo("user1")
            assertThat(it.isLiked).isTrue()
            assertThat(it.likeCount).isEqualTo(10)
            assertThat(it.commentCount).isEqualTo(4)
            assertThat(it.time).isEqualTo("8 hours ago")
        }
    }

}