package com.mandara.redditclone.service;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mandara.redditclone.dto.SubredditDto;
import com.mandara.redditclone.exceptions.SpringRedditException;
import com.mandara.redditclone.mapper.SubredditMapper;
import com.mandara.redditclone.model.Subreddit;
import com.mandara.redditclone.repository.SubredditRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class SubredditService {

	private final SubredditRepository subredditRepository;
	private final SubredditMapper subredditMapper;
	
	@Transactional
	public SubredditDto save(SubredditDto subredditDto) {
		Subreddit save = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto));
		subredditDto.setId(save.getId());
		return subredditDto;
		
	}
//	
//	private Subreddit mapSubredditDto(SubredditDto subredditDto) {
//		return Subreddit.builder().name(subredditDto.getName()).descriptionString(subredditDto.getDescription()).build();
//	}

	@Transactional(readOnly = true)
	public List<SubredditDto> getAllSubreddits() {
		return subredditRepository.findAll().stream().map(subredditMapper::mapSubredditToDto).collect(Collectors.toList());
	}

	public SubredditDto getSubreddit(Long id) {
		Subreddit subreddit = subredditRepository.findById(id).orElseThrow(() -> new SpringRedditException("No Subreddit found"));
		return subredditMapper.mapSubredditToDto(subreddit);
	}
	
//	private SubredditDto mapToDto(Subreddit subreddit) {
//		return SubredditDto.builder().name(subreddit.getName()).description(subreddit.getDescriptionString()).build();
//	}
}

