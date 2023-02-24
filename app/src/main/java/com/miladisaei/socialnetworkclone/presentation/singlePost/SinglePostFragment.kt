package com.miladisaei.socialnetworkclone.presentation.singlePost

import android.content.Context
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.bumptech.glide.Glide
import com.miladisaei.socialnetworkclone.R
import com.miladisaei.socialnetworkclone.data.model.Comment
import com.miladisaei.socialnetworkclone.data.model.Post
import com.miladisaei.socialnetworkclone.databinding.FragmentSinglePostBinding
import com.miladisaei.socialnetworkclone.util.COMMENT_PAGINATION_PAGE_SIZE
import com.miladisaei.socialnetworkclone.util.DummyData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SinglePostFragment : Fragment() {

    private lateinit var binding: FragmentSinglePostBinding
    private lateinit var commentsAdapter: CommentsAdapter
    private val viewModel: SinglePostViewModel by viewModels()

    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.postId = arguments?.getInt("postId")
        viewModel.postId?.let {
            viewModel.getPost()
            viewModel.getComments()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_single_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSinglePostBinding.bind(view)

        initRecyclerView()
        observePostsList()
        initViews()
    }

    private fun observePostsList() {
        showProgressBar()
        viewModel.postLiveData.observe(viewLifecycleOwner) { post ->
            post?.let {
                hideProgressBar()
                initPostDetails(post)
            }
        }
        viewModel.commentsLiveData.observe(viewLifecycleOwner) { newCommentsList ->
            if (isLoading) {
                hideProgressBar()
                hidePaginationProgressBar()
                showLoadMoreButton()
                commentsAdapter.addComments(newCommentsList)

                if (newCommentsList.size < COMMENT_PAGINATION_PAGE_SIZE) {
                    hideLoadMoreButton()
                }
            }
        }
    }

    private fun initRecyclerView() {
        commentsAdapter = CommentsAdapter()
        binding.commentsRecyclerView.apply {
            adapter = commentsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun showProgressBar() {
        isLoading = true
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showLoadMoreButton() {
        binding.loadMoreComment.visibility = View.VISIBLE
    }

    private fun hideLoadMoreButton() {
        binding.loadMoreComment.visibility = View.GONE
    }

    private fun showPaginationProgressBar() {
        isLoading = true
        binding.paginationProgressBar.visibility = View.VISIBLE
    }

    private fun hidePaginationProgressBar() {
        isLoading = false
        binding.paginationProgressBar.visibility = View.GONE
    }

    private fun initViews() {
        binding.imgAddComment.setOnClickListener {
            viewModel.addPageNumber()
            hideLoadMoreButton()
            showPaginationProgressBar()
            viewModel.getComments()
        }
        binding.commentLayout.edtComment.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.commentLayout.edtComment.text.toString().isEmpty())
                    binding.commentLayout.txtSend.setTextColor(resources.getColor(R.color.disableButton))
                else
                    binding.commentLayout.txtSend.setTextColor(resources.getColor(R.color.enableButton))
            }
        })
        binding.commentLayout.txtSend.setOnClickListener {
            if (binding.commentLayout.edtComment.text.toString().isNotEmpty()) {
                viewModel.postLiveData.value?.postId?.let { postId ->
                    val comment = Comment(
                        postId = postId,
                        username = "myUsername",
                        avatar = DummyData.getAvatarUrl(4),
                        message = binding.commentLayout.edtComment.text.toString()
                    )
                    viewModel.saveComment(comment)
                    binding.commentLayout.edtComment.setText("")
                    commentsAdapter.addCommentToFirst(comment)
                    hideKeyboard()
                }
            }
        }
    }

    private fun initPostDetails(post: Post) {
        binding.postLayout.txtUsername.text = post.username
        binding.postLayout.txtUsernameCaption.text = post.username
        binding.postLayout.txtCaption.text = post.postCaption
        binding.postLayout.txtLikeCounter.text = "${post.likeCount} likes"
        binding.postLayout.txtAllComments.visibility = View.GONE
        binding.postLayout.txtTime.text = post.time

        if (post.isLiked) {
            binding.postLayout.imgLike.setImageResource(R.drawable.animation_like)
        } else {
            binding.postLayout.imgLike.setImageResource(R.drawable.animation_dislike)
        }

        Glide.with(binding.postLayout.imgProfile.context)
            .load(post.avatar)
            .placeholder(R.drawable.avatar)
            .into(binding.postLayout.imgProfile)

        Glide.with(binding.postLayout.imgPost.context)
            .load(post.postImage)
            .placeholder(R.drawable.place_holder)
            .into(binding.postLayout.imgPost)

        Glide.with(binding.commentLayout.imgPhoto.context)
            .load(DummyData.getAvatarUrl(4))
            .placeholder(R.drawable.place_holder)
            .into(binding.commentLayout.imgPhoto)

        binding.postLayout.imgLike.setOnClickListener {
            post.isLiked = viewModel.toggleLike(post)
            if (post.isLiked) {
                post.likeCount++
                binding.postLayout.imgLike.setImageResource(R.drawable.animation_like)
                binding.postLayout.imgBigLike.alpha = 0.95f
                likeAnimation(binding.postLayout.imgBigLike)
            } else {
                post.likeCount--
                binding.postLayout.imgLike.setImageResource(R.drawable.animation_dislike)
            }
            binding.postLayout.txtLikeCounter.text = "${post.likeCount} likes"
        }
    }

    private fun likeAnimation(imageView: ImageView) {
        //show animation of Like
        val drawable = imageView.drawable
        imageView.scaleX = 1f
        imageView.scaleY = 1f
        if (drawable is AnimatedVectorDrawableCompat) {
            drawable.start()
        } else if (drawable is AnimatedVectorDrawable) {
            drawable.start()
        }
    }

    private fun hideKeyboard() {
        val view = activity?.currentFocus
        if (view != null) {
            val inputMethodManager =
                activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}