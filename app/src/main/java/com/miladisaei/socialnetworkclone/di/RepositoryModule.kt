package com.miladisaei.socialnetworkclone.di

import com.miladisaei.socialnetworkclone.data.db.CommentDAO
import com.miladisaei.socialnetworkclone.data.db.PostDAO
import com.miladisaei.socialnetworkclone.data.repository.CommentsRepositoryImpl
import com.miladisaei.socialnetworkclone.data.repository.PostsRepositoryImpl
import com.miladisaei.socialnetworkclone.domain.repository.CommentsRepository
import com.miladisaei.socialnetworkclone.domain.repository.PostsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providePostsRepository(
        postDAO: PostDAO
    ): PostsRepository {
        return PostsRepositoryImpl(postDAO)
    }

    @Singleton
    @Provides
    fun provideCommentsRepository(
        commentDAO: CommentDAO,
        postDAO: PostDAO
    ): CommentsRepository {
        return CommentsRepositoryImpl(commentDAO, postDAO)
    }
}