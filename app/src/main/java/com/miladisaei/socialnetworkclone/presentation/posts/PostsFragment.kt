package com.miladisaei.socialnetworkclone.presentation.posts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miladisaei.socialnetworkclone.R
import com.miladisaei.socialnetworkclone.databinding.FragmentPostsBinding
import com.miladisaei.socialnetworkclone.util.POST_PAGINATION_PAGE_SIZE
import com.miladisaei.socialnetworkclone.util.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsFragment : Fragment() {

    private lateinit var binding: FragmentPostsBinding
    private lateinit var postsAdapter: PostsAdapter
    private val viewModel: PostsViewModel by viewModels()

    private var isScrolling = false
    private var isLoading = false
    private var isLastPage = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPostsBinding.bind(view)

        initRecyclerView()
        observePostsList()
    }

    private fun observePostsList() {
        showProgressBar()
        viewModel.postsLiveData.observe(viewLifecycleOwner) { newPostsList ->
            if (isLoading) {
                hideProgressBar()
                hidePagingProgressBar()
                postsAdapter.addPosts(newPostsList)

                if (newPostsList.size < POST_PAGINATION_PAGE_SIZE)
                    isLastPage = true
            }
        }
    }

    private fun initRecyclerView() {
        postsAdapter = PostsAdapter(
            openSingleFragment = { openSinglePostFragment(it) },
            toggleLike = { viewModel.toggleLike(it) }
        )
        binding.postsRecyclerView.apply {
            adapter = postsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(this@PostsFragment.onScrollListener)
        }
    }

    private fun showProgressBar() {
        isLoading = true
        binding.progressBar.visibility = VISIBLE
    }

    private fun hideProgressBar() {
        isLoading = false
        binding.progressBar.visibility = GONE
    }

    private fun showPagingProgressBar() {
        isLoading = true
        binding.pagingProgressBar.visibility = VISIBLE
    }

    private fun hidePagingProgressBar() {
        isLoading = false
        binding.pagingProgressBar.visibility = GONE
    }

    private fun openSinglePostFragment(postId: Int?) {
        viewModel.setPostLiveData(postsAdapter.differ.currentList)
        val bundle = bundleOf("postId" to postId)
        findNavController().navigate(R.id.action_postsFragment_to_singlePostFragment, bundle)
    }


    private val onScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true
            }
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = binding.postsRecyclerView.layoutManager as LinearLayoutManager
            val sizeOfTheCurrentList = layoutManager.itemCount
            val visibleItems = layoutManager.childCount
            val topPosition = layoutManager.findFirstVisibleItemPosition()

            val hasReachedToEnd = topPosition + visibleItems >= sizeOfTheCurrentList
            val shouldPaginate = !isLoading && !isLastPage && hasReachedToEnd && isScrolling
            if (shouldPaginate) {
                viewModel.addPageNumber()
                showPagingProgressBar()
                viewModel.getPosts()
                isScrolling = false
            }
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.fragmentPaused = true
    }

    override fun onResume() {
        super.onResume()
        viewModel.fragmentPaused = false
    }
}