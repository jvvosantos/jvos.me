package me.jvos.microservices.posts.repository;

import me.jvos.microservices.posts.entity.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
