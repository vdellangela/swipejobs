package com.vdellangela.swipejobs;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	public void testWrongHttpMethod() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/worker/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(405));
	}

	@Test
	public void testEmptyId() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/worker").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().is(404));
	}

	@Test
	public void testExistingId() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/worker/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().is(200));
	}
}
