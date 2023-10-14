package com.mandara.redditclone.controller;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mandara.redditclone.dto.PostRequest;
import com.mandara.redditclone.dto.PostResponse;
import com.mandara.redditclone.service.PostService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
@Slf4j
public class PostController {
	
	 private final PostService postService;

	    @PostMapping
	    public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest) {
	    	log.info("Here, inside");
	        postService.save(postRequest);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<PostResponse>> getAllPosts() {
	        return status(HttpStatus.OK).body(postService.getAllPosts());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
	        return status(HttpStatus.OK).body(postService.getPost(id));
	    }

	    @GetMapping(params = "subredditId")
	    public ResponseEntity<List<PostResponse>> getPostsBySubreddit(@RequestParam Long subredditId) {
	        return status(HttpStatus.OK).body(postService.getPostsBySubreddit(subredditId));
	    }

	    @GetMapping(params = "username")
	    public ResponseEntity<List<PostResponse>> getPostsByUsername(@RequestParam String username) {
	        return status(HttpStatus.OK).body(postService.getPostsByUsername(username));
	    }

}
