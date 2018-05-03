package org.gertje.blog;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
public class BlogApplicationTests {

	@LocalServerPort
	int port;

	@Before
	public void init() {
		RestAssured.port = port;
	}

	@Test
	public void getNonExistingPostReturnsNotFound() {
		when().get("/post/1").then().statusCode(HttpStatus.SC_NOT_FOUND);
	}

}
