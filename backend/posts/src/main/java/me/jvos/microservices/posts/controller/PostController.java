package me.jvos.microservices.posts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.jvos.microservices.posts.entity.Post;
import me.jvos.microservices.posts.exception.PostNotFoundException;
import me.jvos.microservices.posts.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping
	public Post post(@RequestBody Post post) {
		return postService.insert(post);
	}

	@PutMapping
	public Post put(@RequestBody Post post) throws PostNotFoundException {
		return postService.update(post);
	}
	
	@GetMapping
	public List<Post> get() {
		return postService.findAll();
	}

	@GetMapping("/{id}")
	public Post getOne(@PathVariable("id") String postId) throws PostNotFoundException {
		return postService.findOne(postId);
	}
	
	@GetMapping("/blog")
	public List<Post> getBlog(){
		return postService.getBlog();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String postId) throws PostNotFoundException {
		postService.delete(postId);
	}

}
