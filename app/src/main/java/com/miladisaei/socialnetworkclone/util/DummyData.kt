package com.miladisaei.socialnetworkclone.util

import com.miladisaei.socialnetworkclone.data.model.Comment
import com.miladisaei.socialnetworkclone.data.model.Post

object DummyData {

    fun getPosts(): List<Post> = listOf(
        Post(username = "user1", avatar = getAvatarUrl(1), postImage = getImageUrl(1), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "8 days ago"),
        Post(username = "user2", avatar = getAvatarUrl(2), postImage = getImageUrl(2), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "8 days ago"),
        Post(username = "user3", avatar = getAvatarUrl(3), postImage = getImageUrl(3), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "6 days ago"),
        Post(username = "user4", avatar = getAvatarUrl(4), postImage = getImageUrl(4), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "6 days ago"),
        Post(username = "user5", avatar = getAvatarUrl(5), postImage = getImageUrl(5), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "6 days ago"),
        Post(username = "user6", avatar = getAvatarUrl(6), postImage = getImageUrl(6), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "6 days ago"),
        Post(username = "user7", avatar = getAvatarUrl(7), postImage = getImageUrl(7), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "6 days ago"),
        Post(username = "user8", avatar = getAvatarUrl(8), postImage = getImageUrl(8), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "5 days ago"),
        Post(username = "user9", avatar = getAvatarUrl(9), postImage = getImageUrl(9), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "5 days ago"),
        Post(username = "user10", avatar = getAvatarUrl(10), postImage = getImageUrl(10), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "5 days ago"),
        Post(username = "user11", avatar = getAvatarUrl(11), postImage = getImageUrl(11), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "5 days ago"),
        Post(username = "user12", avatar = getAvatarUrl(12), postImage = getImageUrl(12), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "5 days ago"),
        Post(username = "user13", avatar = getAvatarUrl(13), postImage = getImageUrl(13), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "5 days ago"),
        Post(username = "user14", avatar = getAvatarUrl(14), postImage = getImageUrl(14), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "5 days ago"),
        Post(username = "user15", avatar = getAvatarUrl(15), postImage = getImageUrl(15), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "5 days ago"),
        Post(username = "user16", avatar = getAvatarUrl(16), postImage = getImageUrl(16), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "4 days ago"),
        Post(username = "user17", avatar = getAvatarUrl(17), postImage = getImageUrl(17), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "4 days ago"),
        Post(username = "user18", avatar = getAvatarUrl(18), postImage = getImageUrl(18), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "4 days ago"),
        Post(username = "user19", avatar = getAvatarUrl(19), postImage = getImageUrl(19), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "4 days ago"),
        Post(username = "user20", avatar = getAvatarUrl(20), postImage = getImageUrl(20), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "4 days ago"),
        Post(username = "user21", avatar = getAvatarUrl(21), postImage = getImageUrl(21), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "4 days ago"),
        Post(username = "user22", avatar = getAvatarUrl(22), postImage = getImageUrl(22), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "4 days ago"),
        Post(username = "user23", avatar = getAvatarUrl(23), postImage = getImageUrl(23), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "4 days ago"),
        Post(username = "user24", avatar = getAvatarUrl(24), postImage = getImageUrl(24), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "4 days ago"),
        Post(username = "user25", avatar = getAvatarUrl(25), postImage = getImageUrl(25), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "3 days ago"),
        Post(username = "user26", avatar = getAvatarUrl(26), postImage = getImageUrl(26), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "3 days ago"),
        Post(username = "user27", avatar = getAvatarUrl(27), postImage = getImageUrl(27), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "3 days ago"),
        Post(username = "user28", avatar = getAvatarUrl(28), postImage = getImageUrl(28), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "3 days ago"),
        Post(username = "user29", avatar = getAvatarUrl(29), postImage = getImageUrl(29), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "3 days ago"),
        Post(username = "user30", avatar = getAvatarUrl(30), postImage = getImageUrl(30), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "3 days ago"),
        Post(username = "user31", avatar = getAvatarUrl(31), postImage = getImageUrl(31), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "3 days ago"),
        Post(username = "user32", avatar = getAvatarUrl(32), postImage = getImageUrl(32), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "3 days ago"),
        Post(username = "user33", avatar = getAvatarUrl(33), postImage = getImageUrl(33), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "3 days ago"),
        Post(username = "user34", avatar = getAvatarUrl(34), postImage = getImageUrl(34), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "2 days ago"),
        Post(username = "user35", avatar = getAvatarUrl(35), postImage = getImageUrl(35), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "2 days ago"),
        Post(username = "user36", avatar = getAvatarUrl(36), postImage = getImageUrl(36), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "2 days ago"),
        Post(username = "user37", avatar = getAvatarUrl(37), postImage = getImageUrl(37), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "2 days ago"),
        Post(username = "user38", avatar = getAvatarUrl(38), postImage = getImageUrl(38), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "2 days ago"),
        Post(username = "user39", avatar = getAvatarUrl(39), postImage = getImageUrl(39), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "9 hours ago"),
        Post(username = "user40", avatar = getAvatarUrl(40), postImage = getImageUrl(40), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "8 hours ago"),
        Post(username = "user41", avatar = getAvatarUrl(41), postImage = getImageUrl(41), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "7 hours ago"),
        Post(username = "user42", avatar = getAvatarUrl(42), postImage = getImageUrl(42), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "6 hours ago"),
        Post(username = "user43", avatar = getAvatarUrl(43), postImage = getImageUrl(43), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "5 hours ago"),
        Post(username = "user44", avatar = getAvatarUrl(44), postImage = getImageUrl(44), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "4 hours ago"),
        Post(username = "user45", avatar = getAvatarUrl(45), postImage = getImageUrl(45), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "3 hours ago"),
        Post(username = "user46", avatar = getAvatarUrl(46), postImage = getImageUrl(46), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "2 hours ago"),
        Post(username = "user47", avatar = getAvatarUrl(47), postImage = getImageUrl(47), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "40 minutes ago"),
        Post(username = "user48", avatar = getAvatarUrl(48), postImage = getImageUrl(48), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "30 minutes ago"),
        Post(username = "user49", avatar = getAvatarUrl(49), postImage = getImageUrl(49), postCaption = "This is a dummy text for caption.", isLiked = true, likeCount = getRandomNumber(), commentCount = 40, time = "20 minutes ago"),
        Post(username = "user50", avatar = getAvatarUrl(50), postImage = getImageUrl(50), postCaption = "This is a dummy text for caption.", isLiked = false, likeCount = getRandomNumber(), commentCount = 40, time = "10 minutes ago"),
    )



    fun getComments(): List<Comment> = listOf(
        Comment(postId = 0, username = "user3", avatar = getAvatarUrl(3), message = "This is a text comment from user3 for this post"),
        Comment(postId = 0, username = "user5", avatar = getAvatarUrl(5), message = "This is a text comment from user5 for this post"),
        Comment(postId = 0, username = "user1", avatar = getAvatarUrl(1), message = "This is a text comment from user1 for this post"),
        Comment(postId = 0, username = "user26", avatar = getAvatarUrl(26), message = "This is a text comment from user26 for this post"),
        Comment(postId = 0, username = "user20", avatar = getAvatarUrl(20), message = "This is a text comment from user20 for this post"),
        Comment(postId = 0, username = "user12", avatar = getAvatarUrl(12), message = "This is a text comment from user12 for this post"),
        Comment(postId = 0, username = "user16", avatar = getAvatarUrl(16), message = "This is a text comment from user16 for this post"),
        Comment(postId = 0, username = "user34", avatar = getAvatarUrl(34), message = "This is a text comment from user34 for this post"),
        Comment(postId = 0, username = "user32", avatar = getAvatarUrl(32), message = "This is a text comment from user32 for this post"),
        Comment(postId = 0, username = "user49", avatar = getAvatarUrl(49), message = "This is a text comment from user49 for this post"),
        Comment(postId = 0, username = "user17", avatar = getAvatarUrl(17), message = "This is a text comment from user17 for this post"),
        Comment(postId = 0, username = "user24", avatar = getAvatarUrl(24), message = "This is a text comment from user24 for this post"),
        Comment(postId = 0, username = "user46", avatar = getAvatarUrl(46), message = "This is a text comment from user46 for this post"),
        Comment(postId = 0, username = "user12", avatar = getAvatarUrl(12), message = "This is a text comment from user12 for this post"),
        Comment(postId = 0, username = "user14", avatar = getAvatarUrl(14), message = "This is a text comment from user14 for this post"),
        Comment(postId = 0, username = "user17", avatar = getAvatarUrl(17), message = "This is a text comment from user17 for this post"),
        Comment(postId = 0, username = "user23", avatar = getAvatarUrl(23), message = "This is a text comment from user23 for this post"),
        Comment(postId = 0, username = "user44", avatar = getAvatarUrl(44), message = "This is a text comment from user44 for this post"),
        Comment(postId = 0, username = "user41", avatar = getAvatarUrl(41), message = "This is a text comment from user41 for this post"),
        Comment(postId = 0, username = "user20", avatar = getAvatarUrl(20), message = "This is a text comment from user20 for this post"),
        Comment(postId = 0, username = "user35", avatar = getAvatarUrl(35), message = "This is a text comment from user35 for this post"),
        Comment(postId = 0, username = "user13", avatar = getAvatarUrl(13), message = "This is a text comment from user13 for this post"),
        Comment(postId = 0, username = "user15", avatar = getAvatarUrl(15), message = "This is a text comment from user15 for this post"),
        Comment(postId = 0, username = "user33", avatar = getAvatarUrl(33), message = "This is a text comment from user33 for this post"),
        Comment(postId = 0, username = "user30", avatar = getAvatarUrl(30), message = "This is a text comment from user30 for this post"),
        Comment(postId = 0, username = "user49", avatar = getAvatarUrl(49), message = "This is a text comment from user49 for this post"),
        Comment(postId = 0, username = "user40", avatar = getAvatarUrl(40), message = "This is a text comment from user40 for this post"),
        Comment(postId = 0, username = "user28", avatar = getAvatarUrl(28), message = "This is a text comment from user28 for this post"),
        Comment(postId = 0, username = "user29", avatar = getAvatarUrl(29), message = "This is a text comment from user29 for this post"),
        Comment(postId = 0, username = "user37", avatar = getAvatarUrl(37), message = "This is a text comment from user37 for this post"),
        Comment(postId = 0, username = "user50", avatar = getAvatarUrl(50), message = "This is a text comment from user50 for this post"),
        Comment(postId = 0, username = "user17", avatar = getAvatarUrl(17), message = "This is a text comment from user17 for this post"),
        Comment(postId = 0, username = "user16", avatar = getAvatarUrl(16), message = "This is a text comment from user16 for this post"),
        Comment(postId = 0, username = "user14", avatar = getAvatarUrl(14), message = "This is a text comment from user14 for this post"),
        Comment(postId = 0, username = "user6", avatar = getAvatarUrl(6), message = "This is a text comment from user6 for this post"),
        Comment(postId = 0, username = "user45", avatar = getAvatarUrl(45), message = "This is a text comment from user45 for this post"),
        Comment(postId = 0, username = "user12", avatar = getAvatarUrl(12), message = "This is a text comment from user12 for this post"),
        Comment(postId = 0, username = "user14", avatar = getAvatarUrl(14), message = "This is a text comment from user14 for this post"),
        Comment(postId = 0, username = "user48", avatar = getAvatarUrl(48), message = "This is a text comment from user48 for this post"),
        Comment(postId = 0, username = "user8", avatar = getAvatarUrl(8), message = "This is a text comment from user8 for this post")
    )


    fun getAvatarUrl(seed: Int): String {
        return if (seed % 2 == 0)
            "https://ware.uncox.com/asset/profile/male/$seed.jpg"
        else
            "https://ware.uncox.com/asset/profile/female/$seed.jpg"
    }

    private fun getImageUrl(seed: Int): String {
        return "https://picsum.photos/seed/$seed/300"
    }

    private fun getRandomNumber(): Int {
        return (Math.random() * 50).toInt()
    }
}