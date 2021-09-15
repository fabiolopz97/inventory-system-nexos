/**
 * 
 */
package com.nexos;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.nexos.model.entities.Merchandise;
import com.nexos.model.entities.User;

/**
 * @author Soluciones
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InventorySystemNexosApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MerchandiseControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllMerchandise() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/merchandise/", HttpMethod.GET, entity,
				String.class);
		System.out.println(response.getBody());
		System.out.println(response.getStatusCodeValue());
		assertNotNull(response.getBody());
	}
	
	@Test
    public void testGetMerchandiseById() {
        Merchandise merchandise = restTemplate.getForObject(getRootUrl() + "/api/v1/merchandise/6", Merchandise.class);
        System.out.println("testGetMerchandiseById() "+merchandise.getNameProduct());
        assertNotNull(merchandise);
    }
	
	@Test
	public void testCreateMerchandise() {
		Merchandise merchandise = new Merchandise();
		User user = new User();
		user.setIdUser(2);
		merchandise.setNameProduct("Ventanas");
		merchandise.setQuantity(5);
		merchandise.setUser(user);;
		merchandise.setAdmissionDate(new Date());

		ResponseEntity<Merchandise> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/merchandise/", merchandise, Merchandise.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateMerchandise() {
		int id = 1;
		Merchandise merchandise = restTemplate.getForObject(getRootUrl() + "/api/v1/merchandise/" + id, Merchandise.class);
		merchandise.setNameProduct("Ventanas2");
		merchandise.setQuantity(2);

		restTemplate.put(getRootUrl() + "/api/v1/merchandise/" + id, merchandise);

		Merchandise updatedMerchandise = restTemplate.getForObject(getRootUrl() + "/api/v1/merchandise/" + id, Merchandise.class);
		assertNotNull(updatedMerchandise);
	}

	@Test
	public void testDeleteMerchandise() {
		int id = 2;
		Merchandise merchandise = restTemplate.getForObject(getRootUrl() + "/api/v1/merchandise/" + id, Merchandise.class);
		assertNotNull(merchandise);

		restTemplate.delete(getRootUrl() + "/api/v1/merchandise/" + id);

		try {
			merchandise = restTemplate.getForObject(getRootUrl() + "/api/v1/merchandise/" + id, Merchandise.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
