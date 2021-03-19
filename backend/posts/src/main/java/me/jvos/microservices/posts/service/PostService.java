package me.jvos.microservices.posts.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import me.jvos.microservices.posts.entity.Post;
import me.jvos.microservices.posts.exception.PostNotFoundException;
import me.jvos.microservices.posts.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post insert(Post post) {
		return postRepository.insert(post);
	}

	public Post update(Post post) throws PostNotFoundException {
		if (!this.postRepository.findById(post.getId()).isPresent()) {
			throw new PostNotFoundException();
		}

		post.setLastModifiedDate(new Date());

		return this.postRepository.save(post);
	}

	public Post findOne(String postId) throws PostNotFoundException {
		Optional<Post> postOptional = this.postRepository.findById(postId);

		if (!postOptional.isPresent()) {
			throw new PostNotFoundException();
		}

		return postOptional.get();
	}

	public List<Post> getBlog(){
		return this.postRepository.findAll(Sort.by(Sort.Direction.DESC, "creationDate"));
	}

	public void delete(String postId) throws PostNotFoundException {
		if (!this.postRepository.findById(postId).isPresent()) {
			throw new PostNotFoundException();
		}

		this.postRepository.deleteById(postId);
	}

	public List<Post> findAll() {
		return this.postRepository.findAll();
	}


}
