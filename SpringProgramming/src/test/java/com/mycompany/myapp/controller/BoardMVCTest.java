package com.mycompany.myapp.controller;

//import static com.mycompany.myapp.TestClass.*; // static method 호출할 때 앞의 class. 을 없이 하게 해주는 것
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;

//import com.mycompany.myapp.TestClass;
import com.mycompany.myapp.*;

public class BoardMVCTest extends ApplicationContextLoader {

	private static final Logger logger = LoggerFactory.getLogger(BoardMVCTest.class);
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Before
	public void setUp() {
		logger.info("setup");
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testList() throws Exception {
		logger.info("list");
		mockMvc.perform(get("/board/list"))
			.andExpect(model().attributeExists("list"))
			.andExpect(view().name("board/list"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void testWrite() throws Exception {
		logger.info("write");
		
		mockMvc.perform(
				post("/board/write")
				.param("title","test1")
				.param("content", "content1")
				.param("writer", "testwriter1"))
		.andExpect(redirectedUrl("board/list"));
	}
	
}
