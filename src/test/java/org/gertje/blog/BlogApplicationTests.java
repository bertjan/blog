package org.gertje.blog;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
public class BlogApplicationTests {

	@Test
	public void getNonExistingPostReturnsNotFound() {
		when().get("/post/1").then().statusCode(HttpStatus.SC_NOT_FOUND);
	}

}
