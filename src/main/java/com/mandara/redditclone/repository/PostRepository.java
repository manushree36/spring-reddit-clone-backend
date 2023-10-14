package com.mandara.redditclone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mandara.redditclone.model.Post;
import com.mandara.redditclone.model.Subreddit;
import com.mandara.redditclone.model.User;

public interface PostRepository extends JpaRepository<Post, Long> {
	List<Post> findAllBySubreddit(Subreddit subreddit);

	List<Post> findByUser(User user);
}
