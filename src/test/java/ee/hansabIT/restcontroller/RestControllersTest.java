package ee.hansabIT.restcontroller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Arrays;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import ee.hansabIT.entity.*;
import ee.hansabIT.service.*;

@WebMvcTest({CarController.class, UserController.class})
public class RestControllersTest {
	
	@MockBean
	private CarService carService;
	
	@MockBean
	private UserService userService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("Should list all succesful responses for car's calls")
	public void getSuccesfulResponsesForCarsCalls() throws Exception {
		
		when(carService.getCarBySearchField("_", PageRequest.of(0,10,
				Sort.Direction.fromString("asc"), "id")))
		.thenReturn(Arrays.asList(new Car(), new Car()));
		
		 mockMvc.perform(MockMvcRequestBuilders.get("/cars").accept(MediaType.APPLICATION_JSON))
		 .andExpect(MockMvcResultMatchers.status().is(200))
		 .andExpect(content().json("[{},{}]"))
		 .andReturn();
		 
		 when(carService.getCarById(1L)).thenReturn(new Car());
		 
		 mockMvc.perform(MockMvcRequestBuilders.get("/cars/1").accept(MediaType.APPLICATION_JSON))
		 .andExpect(MockMvcResultMatchers.status().is(200))
		 .andExpect(content().json("{}"))
		 .andReturn();
		 
	}
	
	@Test
	@DisplayName("Should list all empty responses for car's calls")
	public void getEmptyResponsesForCarsCalls() throws Exception {
		
		when(carService.getCarBySearchField(null, null))
		.thenReturn(null);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/cars").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(204))
		.andReturn();
		
		when(carService.getCarById(1L)).thenReturn(null);
		 
		 mockMvc.perform(MockMvcRequestBuilders.get("/cars/1").accept(MediaType.APPLICATION_JSON))
		 .andExpect(MockMvcResultMatchers.status().is(204))
		 .andReturn();
	}
	
	@Test
	@DisplayName("Should list all succesful responses for user's calls")
	public void getSuccesfulResponsesForUserCalls() throws Exception {
		
		when(userService.getUserByName("_", PageRequest.of(0,10,
				Sort.Direction.fromString("asc"), "name")))
		.thenReturn(Arrays.asList(new User(), new User()));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
		 .andExpect(MockMvcResultMatchers.status().is(200))
		 .andExpect(content().json("[{},{}]"))
		 .andReturn();
		
		when(userService.getUserById(1L)).thenReturn(new User());
		 
		 mockMvc.perform(MockMvcRequestBuilders.get("/users/1").accept(MediaType.APPLICATION_JSON))
		 .andExpect(MockMvcResultMatchers.status().is(200))
		 .andExpect(content().json("{}"))
		 .andReturn();
		
	}
	
	@Test
	@DisplayName("Should list all empty responses for user's calls")
	public void getEmptyResponsesForUsersCalls() throws Exception {
		
		when(userService.getUserByName(null, null))
		.thenReturn(null);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(204))
		.andReturn();
		
		when(carService.getCarById(1L)).thenReturn(null);
		 
		 mockMvc.perform(MockMvcRequestBuilders.get("/users/1").accept(MediaType.APPLICATION_JSON))
		 .andExpect(MockMvcResultMatchers.status().is(204))
		 .andReturn();
	}
}
