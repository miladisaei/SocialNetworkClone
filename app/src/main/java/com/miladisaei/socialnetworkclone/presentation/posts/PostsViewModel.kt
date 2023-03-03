package com.miladisaei.socialnetworkclone.presentation.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miladisaei.socialnetworkclone.data.model.Post
import com.miladisaei.socialnetworkclone.domain.usecase.GetPostsUseCase
import com.miladisaei.socialnetworkclone.domain.usecase.LikePostUseCase
import com.miladisaei.socialnetworkclone.domain.usecase.UnlikePostUseCase
import com.miladisaei.socialnetworkclone.util.POST_PAGINATION_PAGE_SIZE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel
@Inject
constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val likePostUseCase: LikePostUseCase,
    private val unlikePostUseCase: UnlikePostUseCase
) : ViewModel() {

    private val _postsLiveData: MutableLiveData<List<Post>> = MutableLiveData()
    val postsLiveData: LiveData<List<Post>> = _postsLiveData

    var page = 1
    var fragmentPaused = false

    init {
        getPosts()
    }

    fun addPageNumber() = page++

    fun setPostLiveData(postsList: List<Post>) {
        _postsLiveData.postValue(postsList)
    }

    fun getPosts() = viewModelScope.launch(Dispatchers.IO) {
        delay(1500) // for Debug
        getPostsUseCase.execute(
            page = page,
            count = POST_PAGINATION_PAGE_SIZE
        ).collect { postsResult ->
            if (!fragmentPaused)
                _postsLiveData.postValue(postsResult)
            else {
                updatePostList(postsResult)
            }
        }
    }

    private fun updatePostList(subPostList: List<Post>) {
        val parentPostList = _postsLiveData.value?.toMutableList()
        for (post in subPostList) {
            val index = parentPostList?.indexOfFirst { it.postId == post.postId }
            if (index != -1 && parentPostList != null && index != null) {
                if (post != parentPostList[index]) {
                    parentPostList[index] = post
                }
            }
        }
        parentPostList?.let {
            _postsLiveData.postValue(it)
        }
    }

    fun toggleLike(post: Post): Boolean {
        post.postId?.let {
            if (post.isLiked) {
                unlikePost(it)
                return false
            } else {
                likePost(it)
                return true
            }
        }
        return false
    }

    private fun likePost(postId: Int) = viewModelScope.launch(Dispatchers.IO) {
        likePostUseCase.execute(postId)
    }

    private fun unlikePost(postId: Int) = viewModelScope.launch(Dispatchers.IO) {
        unlikePostUseCase.execute(postId)
    }
}