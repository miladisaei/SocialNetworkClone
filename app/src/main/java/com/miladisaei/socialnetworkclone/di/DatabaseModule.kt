package com.miladisaei.socialnetworkclone.di

import android.app.Application
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.miladisaei.socialnetworkclone.data.db.CommentDAO
import com.miladisaei.socialnetworkclone.data.db.PostDAO
import com.miladisaei.socialnetworkclone.data.db.SocialNetworkDatabase
import com.miladisaei.socialnetworkclone.util.DummyData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    lateinit var socialNetworkDatabase: SocialNetworkDatabase

    @Singleton
    @Provides
    fun provideSocialNetworkDatabase(
        app: Application,
    ): SocialNetworkDatabase {
        socialNetworkDatabase =
            Room.databaseBuilder(app, SocialNetworkDatabase::class.java, "social_network_db")
                .fallbackToDestructiveMigration()
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        // do something after database has been created
                        CoroutineScope(Dispatchers.IO).launch {
                            socialNetworkDatabase.getPostDAO().insertPostList(DummyData.getPosts())
                            socialNetworkDatabase.getCommentDAO()
                                .insertCommentList(DummyData.getComments())
                        }
                    }
                })
                .build()
        return socialNetworkDatabase
    }

    @Singleton
    @Provides
    fun providePostDao(socialNetworkDatabase: SocialNetworkDatabase): PostDAO {
        return socialNetworkDatabase.getPostDAO()
    }

    @Singleton
    @Provides
    fun provideCommentDao(socialNetworkDatabase: SocialNetworkDatabase): CommentDAO {
        return socialNetworkDatabase.getCommentDAO()
    }

}