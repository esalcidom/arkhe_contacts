package com.esalcido.arkhe.contacts.arkhe_contacts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.esalcido.arkhe.contacts.arkhe_contacts.controller.ContactRestController;

@RunWith(SpringRunner.class)
// @WebMvcTest(ContactRestController.class)
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

	// mvc.perform( MockMvcRequestBuilders
	// .get("/employees")
	// .accept(MediaType.APPLICATION_JSON))
	// .andDo(print())
	// .andExpect(status().isOk())
	// .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
	// .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());

}
