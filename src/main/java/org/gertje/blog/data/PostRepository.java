package org.gertje.blog.data;

import org.gertje.blog.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

	Post findByTitle(String title);

	List<Post> findByTagListValue(String value);
}
