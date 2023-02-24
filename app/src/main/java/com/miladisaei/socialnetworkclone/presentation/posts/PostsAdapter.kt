package com.miladisaei.socialnetworkclone.presentation.posts

import android.graphics.drawable.AnimatedVectorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.bumptech.glide.Glide
import com.miladisaei.socialnetworkclone.R
import com.miladisaei.socialnetworkclone.data.model.Post
import com.miladisaei.socialnetworkclone.databinding.PostsListItemBinding

class PostsAdapter
constructor(
    private val openSingleFragment: (Int?) -> Unit,
    private val toggleLike: (Post) -> Boolean
) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.postId == newItem.postId
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    fun addPosts(newItems: List<Post>) {
        val newList = mutableListOf<Post>().apply {
            addAll(differ.currentList)
            addAll(newItems)
        }
        differ.submitList(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding = PostsListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = differ.currentList[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    inner class PostsViewHolder(
        private val binding: PostsListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.txtUsername.text = post.username
            binding.txtUsernameCaption.text = post.username
            binding.txtCaption.text = post.postCaption
            binding.txtLikeCounter.text = "${post.likeCount} likes"
            binding.txtAllComments.text = "View all ${post.commentCount} comments"
            binding.txtTime.text = post.time

            if (post.isLiked) {
                binding.imgLike.setImageResource(R.drawable.animation_like)
            } else {
                binding.imgLike.setImageResource(R.drawable.animation_dislike)
            }

            Glide.with(binding.imgProfile.context)
                .load(post.avatar)
                .placeholder(R.drawable.avatar)
                .into(binding.imgProfile)

            Glide.with(binding.imgPost.context)
                .load(post.postImage)
                .placeholder(R.drawable.place_holder)
                .into(binding.imgPost)

            binding.root.setOnClickListener { openSingleFragment(post.postId) }

            binding.imgLike.setOnClickListener {
                post.isLiked = toggleLike(post)
                if (post.isLiked) {
                    post.likeCount++
                    binding.imgLike.setImageResource(R.drawable.animation_like)
                    binding.imgBigLike.alpha = 0.95f
                    likeAnimation(binding.imgBigLike)
                } else {
                    post.likeCount--
                    binding.imgLike.setImageResource(R.drawable.animation_dislike)
                }
                likeAnimation(binding.imgLike)
                binding.txtLikeCounter.text = "${post.likeCount} likes"
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

    }
}