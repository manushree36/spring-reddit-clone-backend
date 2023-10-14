package com.mandara.redditclone.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import com.mandara.redditclone.dto.SubredditDto;
import com.mandara.redditclone.model.Post;
import com.mandara.redditclone.model.Subreddit;


@Mapper(componentModel = "spring")
public interface SubredditMapper {

	@Mapping(target = "numberOfPosts", expression = "java(mapPosts(subreddit.getPosts()))")
	@Mapping(target = "description", source = "descriptionString")
	SubredditDto mapSubredditToDto(Subreddit subreddit);
	
	default Integer mapPosts(List<Post> numberOfPosts) { return numberOfPosts.size();}
	
	@InheritInverseConfiguration
	@Mapping(target = "posts", ignore = true)
	@Mapping(target = "descriptionString", source = "description")
	Subreddit mapDtoToSubreddit(SubredditDto subredditDto);

}
