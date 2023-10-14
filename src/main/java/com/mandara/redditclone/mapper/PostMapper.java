package com.mandara.redditclone.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mandara.redditclone.dto.PostRequest;
import com.mandara.redditclone.dto.PostResponse;
import com.mandara.redditclone.model.Post;
import com.mandara.redditclone.model.Subreddit;
import com.mandara.redditclone.model.User;

@Mapper(componentModel = "spring")
public interface PostMapper {
	//Mapping from PostRequest to Post
	@Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
	@Mapping(target = "description", source = "postRequest.description")
	Post map(PostRequest postRequest, Subreddit subreddit, User user);
	
	//Mapping from Post to PostResponse
	@Mapping(target = "id", source = "postId")
	@Mapping(target = "subredditName", source = "subreddit.name")
	@Mapping(target = "userName", source = "user.userName")
	PostResponse mapToDto(Post post);
	

}
