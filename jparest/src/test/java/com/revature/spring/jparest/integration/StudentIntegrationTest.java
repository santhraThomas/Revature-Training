package com.revature.spring.jparest.integration;

import com.revature.spring.jparest.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class StudentIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private String getBaseUrl() {
		return "http://localhost:" + port + "/students";
	}

	@Test
	void testCreateAndGetStudent() {
		Student newStudent = new Student("Alice", "alice@example.com", "Math");
		ResponseEntity<Student> postResponse = restTemplate.postForEntity(getBaseUrl(), newStudent, Student.class);
		assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		Student created = postResponse.getBody();
		assertThat(created).isNotNull();
		assertThat(created.getId()).isNotNull();
		assertThat(created.getName()).isEqualTo("Alice");

		// Get all students
		ResponseEntity<Student[]> getAllResponse = restTemplate.getForEntity(getBaseUrl(), Student[].class);
		assertThat(getAllResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(getAllResponse.getBody()).isNotEmpty();

		// Get by id
		ResponseEntity<Student> getByIdResponse = restTemplate.getForEntity(getBaseUrl() + "/" + created.getId(), Student.class);
		assertThat(getByIdResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(getByIdResponse.getBody().getName()).isEqualTo("Alice");
	}

	@Test
	void testUpdateAndDeleteStudent() {
		Student newStudent = new Student("Bob", "bob@example.com", "Science");
		Student created = restTemplate.postForEntity(getBaseUrl(), newStudent, Student.class).getBody();
		assertThat(created).isNotNull();

		// Update
		created.setName("Bobby");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Student> entity = new HttpEntity<>(created, headers);
		ResponseEntity<Student> updateResponse = restTemplate.exchange(getBaseUrl() + "/" + created.getId(), HttpMethod.PUT, entity, Student.class);
		assertThat(updateResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(updateResponse.getBody().getName()).isEqualTo("Bobby");

		// Delete
		restTemplate.delete(getBaseUrl() + "/" + created.getId());
		ResponseEntity<Student> getAfterDelete = restTemplate.getForEntity(getBaseUrl() + "/" + created.getId(), Student.class);
		assertThat(getAfterDelete.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
}
