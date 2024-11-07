package com.cursosdedesarrollo.aplicacion_rest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;

import org.springframework.test.web.servlet.MockMvc;


import com.cursosdedesarrollo.aplicacion_rest.controllers.MainRestController;

@SpringBootTest
@AutoConfigureMockMvc
class AplicacionRestApplicationTests {

	@Autowired
	private MainRestController controller;

	@Test
	void contextLoads() {
	}

	@Test
	public void myRestControllerLoads() throws Exception {
		assertNotNull(controller);
	}

	@Autowired
	public MockMvc mockMvc;

	@Test
	public void shouldReturnHello() throws Exception {
		this.mockMvc.perform(
			get("/hello")
		).andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Hello")));
	}

}
