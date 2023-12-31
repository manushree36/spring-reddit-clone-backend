package com.mandara.redditclone.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mandara.redditclone.dto.CommentsDto;
import com.mandara.redditclone.model.Comment;
import com.mandara.redditclone.model.Post;
import com.mandara.redditclone.model.User;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "text", source = "commentsDto.text")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "post", source = "post")
    @Mapping(target = "user", source = "user")
    Comment map(CommentsDto commentsDto, Post post, User user);

    @Mapping(target = "postId", expression = "java(comment.getPost().getPostId())")
    @Mapping(target = "userName", expression = "java(comment.getUser().getUserName())")
    CommentsDto mapToDto(Comment comment);
}