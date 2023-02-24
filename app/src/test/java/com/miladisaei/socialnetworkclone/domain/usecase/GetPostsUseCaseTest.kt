package com.miladisaei.socialnetworkclone.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.miladisaei.socialnetworkclone.data.repository.FakePostsRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetPostsUseCaseTest {

    private lateinit var getPostsUseCase: GetPostsUseCase
    private lateinit var fakePostRepository: FakePostsRepositoryImpl

    @Before
    fun setUp() {
        fakePostRepository = FakePostsRepositoryImpl()
        getPostsUseCase = GetPostsUseCase(fakePostRepository)
    }

    @Test
    fun getPosts_success() = runBlocking {
        getPostsUseCase.execute(
            page = 1,
            count = 10
        ).collect {
            assertThat(it.size).isEqualTo(1)
            assertThat(it[0].postId).isEqualTo(1)
            assertThat(it[0].username).isEqualTo("user1")
            assertThat(it[0].isLiked).isTrue()
            assertThat(it[0].likeCount).isEqualTo(10)
            assertThat(it[0].commentCount).isEqualTo(4)
            assertThat(it[0].time).isEqualTo("8 hours ago")
        }
    }

}