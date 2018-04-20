package org.gertje.blog.service;

import org.gertje.blog.model.Post;

import java.util.List;

public interface PostService {

	Post read(long id);

	List<Post> findByTag(String name);
}
