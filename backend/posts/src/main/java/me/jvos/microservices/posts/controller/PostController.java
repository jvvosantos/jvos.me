package me.jvos.microservices.posts.controller;

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
import me.jvos.microservices.posts.repository.PostRepository;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostRepository repository;

	@PostMapping
	public Post create(@RequestBody Post post) {
		return repository.insert(post);
	}

	@PutMapping
	public Post put(@RequestBody Post post) {
		Post oldPost = repository.findById(post.getId()).get();
		
		post.setCreatedDate(oldPost.getCreatedDate());
		
		return repository.save(post);
	}

	@GetMapping("/{id}")
	public Post get(@PathVariable("id") String postId) {
		return repository.findById(postId).get();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String postId) {
		repository.deleteById(postId);
	}

}
