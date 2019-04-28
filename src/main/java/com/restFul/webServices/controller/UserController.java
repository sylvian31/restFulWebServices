package com.restFul.webServices.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restFul.webServices.bean.Post;
import com.restFul.webServices.bean.User;
import com.restFul.webServices.exception.UserNotFoundException;
import com.restFul.webServices.repository.PostRepository;
import com.restFul.webServices.service.UserDAOService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDAOService userDAOService;
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping
	public List<User> getAllUsers() {
		return userDAOService.findAll();
	}

	@GetMapping(path = "/{id}")
	public Resource<User> getUserById(@PathVariable Integer id) {
		User user = userDAOService.findById(id);
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@PostMapping
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) throws URISyntaxException {
		User savedUser = userDAOService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		userDAOService.deleteById(id);
	}
	
	@GetMapping("/{id}/posts")
	public List<Post> getPostsByUserId(@PathVariable Integer id) {
		User user = userDAOService.findById(id);
		return user.getPosts();
	}
	
	@PostMapping(path = "/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable Integer id, @Valid @RequestBody Post post) throws URISyntaxException {
		User user = userDAOService.findById(id);
		
		post.setUser(user);
		
		postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	
	
}
