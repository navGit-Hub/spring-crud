package com.crud.springcrud;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.crud.springcrud.entity.Products;
import com.crud.springcrud.repository.ProductRepository;
import com.crud.springcrud.service.ProductService;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
<<<<<<< HEAD
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcrudApplicationTests {

	
=======

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcrudApplicationTests {

	@Autowired
	private ProductService service;

	@MockBean
	private ProductRepository repository;

	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Products()))
	}

	@Test
	public void getUserbyAddressTest() {
		String address = "Bangalore";
		when(repository.findByAddress(address))
				.thenReturn(Stream.of(new User(376, "Danile", 31, "USA")).collect(Collectors.toList()));
		assertEquals(1, service.getUserbyAddress(address).size());
	}

	@Test
	public void saveUserTest() {
		User user = new User(999, "Pranya", 33, "Pune");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}

	@Test
	public void deleteUserTest() {
		User user = new User(999, "Pranya", 33, "Pune");
		service.deleteUser(user);
		verify(repository, times(1)).delete(user);
	}
>>>>>>> 386bfce34497eb1fec015c8608dcda9365e1db39

}
