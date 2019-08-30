package com.esalcido.arkhe.contacts.arkhe_contacts;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


@RunWith(SpringRunner.class)
//@WebMvcTest(ContactRestController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class DemoApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void contactListNotEmpty() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/rest/contacts").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[*]").isNotEmpty());
	}

	@Test
	public void firstContact() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/rest/contacts").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[*].contactId").value(1));
	}

	@Test
	public void addressListNotEmpty() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/rest/addresses").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[*]").isNotEmpty());
	}

	TestRestTemplate restTemplate;
    URL base;
    @LocalServerPort int port;


	@Before
    public void setUp() throws MalformedURLException {
        restTemplate = new TestRestTemplate("user", "password");
        base = new URL("http://localhost:" + port);
	}
	
	@Test
    public void whenLoggedUserRequestsHomePage_ThenSuccess()
     throws IllegalStateException, IOException {
        ResponseEntity<String> response 
          = restTemplate.getForEntity(base.toString(), String.class);
  
        assertEquals(HttpStatus.OK, response.getStatusCode());
        
	}
	
	@Test
    public void whenUserWithWrongCredentials_thenUnauthorizedPage() 
      throws Exception {
  
        restTemplate = new TestRestTemplate("user", "wrongpassword");
        ResponseEntity<String> response 
          = restTemplate.getForEntity(base.toString(), String.class);
  
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }
}
