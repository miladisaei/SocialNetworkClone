package com.miladisaei.socialnetworkclone.presentation.singlePost

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miladisaei.socialnetworkclone.data.model.Comment
import com.miladisaei.socialnetworkclone.data.model.Post
import com.miladisaei.socialnetworkclone.domain.usecase.*
import com.miladisaei.socialnetworkclone.util.COMMENT_PAGINATION_PAGE_SIZE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SinglePostViewModel
@Inject
constructor(
    private val getSinglePostUseCase: GetSinglePostUseCase,
    private val getCommentsUseCase: GetCommentsUseCase,
    private val addCommentUseCase: AddCommentUseCase,
    private val likePostUseCase: LikePostUseCase,
    private val unlikePostUseCase: UnlikePostUseCase
) : ViewModel() {

    private val _commentsLiveData: MutableLiveData<List<Comment>> = MutableLiveData()
    val commentsLiveData: LiveData<List<Comment>> = _commentsLiveData

    private val _postLiveData: MutableLiveData<Post> = MutableLiveData()
    val postLiveData: LiveData<Post> = _postLiveData

    var postId: Int? = 0
    var offset = 0

    fun addPageNumber() {
        offset += COMMENT_PAGINATION_PAGE_SIZE
    }

    fun getComments() = viewModelScope.launch(Dispatchers.IO) {
        postId?.let {
            delay(1000) // for Debug
            getCommentsUseCase.execute(
                postId = it,
                count = COMMENT_PAGINATION_PAGE_SIZE,
                offset = offset
            ).collect { postsResult ->
                _commentsLiveData.postValue(postsResult)
            }
        }
    }

    fun getPost() = viewModelScope.launch(Dispatchers.IO) {
        postId?.let {
            delay(500) // for Debug
            getSinglePostUseCase.execute(
                postId = it
            ).collect { postResult ->
                _postLiveData.postValue(postResult)
            }
        }
    }

    fun saveComment(comment: Comment) = viewModelScope.launch(Dispatchers.IO) {
        offset++
        addCommentUseCase.execute(comment)
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