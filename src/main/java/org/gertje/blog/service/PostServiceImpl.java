package org.gertje.blog.service;

import org.gertje.blog.data.PostRepository;
import org.gertje.blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepository;

	@Autowired
	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public Post read(long id) {
		Post post = postRepository.findOne(id);

		if (post == null) {
			throw new NotFoundException("No post found with id '" + id + "'");
		}

		return post;
	}

	@Override
	public List<Post> findByTag(String name) {
		List<Post> postList = postRepository.findByTagListValue(name);

		if (postList == null || postList.isEmpty()) {
			throw new NotFoundException("No posts found for tag '" + name + "'");
		}

		return postList;
	}
}
