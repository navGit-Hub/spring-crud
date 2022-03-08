package com.crud.springcrud;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.crud.springcrud.entity.Products;
import com.crud.springcrud.entity.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcrudApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	ObjectMapper om = new ObjectMapper();

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void saveProductTest() throws Exception {
		Products product = new Products();
		product.setName("Mobile");
		product.setPrice(2000.0);
		product.setQuantity(10);
		String jsonRequest = om.writeValueAsString(product);
		MvcResult result = mockMvc.perform(
				post("/ProductService/saveProduct").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent, Response.class);
		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
	}

	@Test
	public void getProductTest() throws Exception {

		MvcResult result = mockMvc
				.perform(get("/ProductService/getProduct").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent, Response.class);
		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
	}

	
	@Test
	public void getProductByIdTest() throws Exception {
		Products product = new Products();
		product.setId(2);
		product.setName("Mobile");
		product.setPrice(2000.0);
		product.setQuantity(10);
		String jsonRequest = om.writeValueAsString(product);
		MvcResult result = mockMvc.perform(
				get("/ProductService/getProductById/2").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent, Response.class);
		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
	}
	
	@Test
	public void deleteProductByIdTest() throws Exception {
		Products product = new Products();
		product.setId(2);
		product.setName("Mobile");
		product.setPrice(2000.0);
		product.setQuantity(10);
		String jsonRequest = om.writeValueAsString(product);
		MvcResult result = mockMvc.perform(
				delete("/ProductService/deleteProduct/2").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent, Response.class);
		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
	}

	@Test
	public void getProductByNameTest() throws Exception {
		Products product = new Products();
		product.setName("Mobile");
		product.setPrice(2000.0);
		product.setQuantity(10);
		String jsonRequest = om.writeValueAsString(product);
		MvcResult result = mockMvc.perform(
				get("/ProductService/getProductByName/Mobile").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent, Response.class);
		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
	}


}
