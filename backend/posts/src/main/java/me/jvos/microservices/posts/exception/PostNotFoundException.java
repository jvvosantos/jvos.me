package me.jvos.microservices.posts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PostNotFoundException extends Exception {

	private static final long serialVersionUID = -5857568810599384108L;
	
	public PostNotFoundException() {
		super("Post not found!");
	}

}
