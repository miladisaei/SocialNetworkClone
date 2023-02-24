package com.miladisaei.socialnetworkclone.di

import com.miladisaei.socialnetworkclone.domain.repository.CommentsRepository
import com.miladisaei.socialnetworkclone.domain.repository.PostsRepository
import com.miladisaei.socialnetworkclone.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetPostsUseCase(
        postsRepository: PostsRepository
    ): GetPostsUseCase {
        return GetPostsUseCase(postsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSinglePostUseCase(
        postsRepository: PostsRepository
    ): GetSinglePostUseCase {
        return GetSinglePostUseCase(postsRepository)
    }

    @Singleton
    @Provides
    fun provideLikePostUseCase(
        postsRepository: PostsRepository
    ): LikePostUseCase {
        return LikePostUseCase(postsRepository)
    }

    @Singleton
    @Provides
    fun provideUnlikePostUseCase(
        postsRepository: PostsRepository
    ): UnlikePostUseCase {
        return UnlikePostUseCase(postsRepository)
    }

    @Singleton
    @Provides
    fun provideGetCommentsUseCase(
        commentsRepository: CommentsRepository
    ): GetCommentsUseCase {
        return GetCommentsUseCase(commentsRepository)
    }

    @Singleton
    @Provides
    fun provideAddCommentUseCase(
        commentsRepository: CommentsRepository
    ): AddCommentUseCase {
        return AddCommentUseCase(commentsRepository)
    }
}