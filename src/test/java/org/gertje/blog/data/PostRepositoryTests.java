package org.gertje.blog.data;

import org.gertje.blog.model.Post;
import org.gertje.blog.model.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PostRepository postRepository;

	@Test
	public void givenSomePostWhenSearchingThenFindIt() {
		// Given some post ...
		Post post = new Post("Title", "Some content.");
		entityManager.persist(post);
		entityManager.flush();

		// when we search for it ...
		Post read = postRepository.findByTitle("Title");

		// then we should find it.
		assertThat(read.getContent()).isEqualTo(post.getContent());
	}

	@Test
	public void givenSomePostWithTagsWhenSearchingThenFindIt() {
		// Given some post ...
		Post post = new Post("Title", "Some content.");
		post.setTagList(Stream.of("a", "b", "c").map(Tag::new).collect(Collectors.toList()));
		entityManager.persist(post);
		entityManager.flush();

		// when we search for it ...
		List<Post> read = postRepository.findByTagListValue("a");

		// then we should find it.
		assertThat(read.size()).isEqualTo(0);
		Post first = read.get(0);
		assertThat(first.getContent()).isEqualTo(post.getContent());
	}
}
