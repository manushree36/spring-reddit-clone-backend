package com.mandara.redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mandara.redditclone.model.Comment;
import com.mandara.redditclone.model.Post;
import com.mandara.redditclone.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}