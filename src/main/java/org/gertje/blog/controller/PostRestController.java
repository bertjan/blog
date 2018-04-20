package org.gertje.blog.controller;

import org.gertje.blog.model.Post;
import org.gertje.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostRestController {

	private PostService postService;

	@Autowired
	public PostRestController(PostService postService) {
		this.postService = postService;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Post read(@PathVariable long id) {
		return postService.read(id);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Post> fin(@RequestParam("tag") String tag) {
		return postService.findByTag(tag);
	}

}
