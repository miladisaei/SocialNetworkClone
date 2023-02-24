package com.miladisaei.socialnetworkclone.presentation.singlePost

import android.text.Html
import android.text.SpannableString
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miladisaei.socialnetworkclone.R
import com.miladisaei.socialnetworkclone.data.model.Comment
import com.miladisaei.socialnetworkclone.databinding.CommentsListItemBinding

class CommentsAdapter : RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Comment>() {
        override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem.commentId == newItem.commentId
        }

        override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    fun addCommentToFirst(item: Comment) {
        val newList = mutableListOf<Comment>().apply {
            addAll(differ.currentList)
            add(0, item)
        }
        differ.submitList(newList)
    }

    fun addComments(newItems: List<Comment>) {
        val newList = mutableListOf<Comment>().apply {
            addAll(differ.currentList)
            addAll(newItems)
        }
        differ.submitList(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val binding = CommentsListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        val comment = differ.currentList[position]
        holder.bind(comment)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    inner class CommentsViewHolder(
        private val binding: CommentsListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(comment: Comment) {
            setupCommentText(
                commentUsername = comment.username,
                commentText = comment.message
            )

            Glide.with(binding.imgPhoto.context)
                .load(comment.avatar)
                .placeholder(R.drawable.place_holder)
                .into(binding.imgPhoto)

        }

        private fun setupCommentText(
            commentUsername: String,
            commentText: String
        ) {
            val comment = "<b>$commentUsername</b> $commentText"
            val spannableComment = SpannableString(Html.fromHtml(comment))

            binding.txtComment.text = spannableComment
            binding.txtComment.setLinkTextColor(binding.txtComment.context.resources.getColor(R.color.textColor))
        }
    }
}