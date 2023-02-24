package com.miladisaei.socialnetworkclone.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.miladisaei.socialnetworkclone.data.repository.FakeCommentsRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCommentsUseCaseTest {

    private lateinit var getCommentsUseCase: GetCommentsUseCase
    private lateinit var fakeCommentsRepository: FakeCommentsRepositoryImpl

    @Before
    fun setUp() {
        fakeCommentsRepository = FakeCommentsRepositoryImpl()
        getCommentsUseCase = GetCommentsUseCase(fakeCommentsRepository)
    }

    @Test
    fun getComments_success() = runBlocking {
        getCommentsUseCase.execute(
            postId = 2,
            count = 10,
            offset = 0
        ).collect {
            assertThat(it.size).isEqualTo(1)
            assertThat(it[0].commentId).isEqualTo(1)
            assertThat(it[0].postId).isEqualTo(2)
            assertThat(it[0].username).isEqualTo("user1")
            assertThat(it[0].message).isEqualTo("This is a Test Message")
        }
    }

    @Test
    fun getComments_empty() = runBlocking {
        getCommentsUseCase.execute(
            postId = 1,
            count = 10,
            offset = 0
        ).collect {
            assertThat(it.size).isEqualTo(0)
        }
    }

}