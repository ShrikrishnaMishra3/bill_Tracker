package com.billTracker.functionalcases;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.billTracker.Service.BillService;
import com.billTracker.controller.BillController;

import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

class BillControllerTest {

	
	@Mock
	private BillService billService;
	
	@InjectMocks
	private BillController billController;
	
	private MockMvc mockmvc;
	
	static {
		File file = new File("output_controller_revised.txt");
		if (file.exists() && file.length()==0 ) {
			try {
				FileUtils.forceDelete(new File("output_functional_revised.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}
		
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockmvc = MockMvcBuilders.standaloneSetup(billController).build();
	}
	
	/*
	 * testHomePage method is expected to test the landing page of index.jsp
	 */
	
	@Test
	void testShowHomePage() throws Exception {
	MvcResult result = this.mockmvc.perform(get("/")).andExpect(view().name("index")).andReturn();
	File file = new File("output_functional_revised.txt"); 
	FileUtils.write(file, "\n testShowHomePage ="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	
	}

	/*
	 * testStatusPage method is expected to test the statusmanager.jsp page is 
	 * loading expected result value is true.
	 */
	@Test
	void testStatusPage() throws Exception {
		MvcResult result = this.mockmvc.perform(get("/tracker")).andExpect(view().name("tracker")).andReturn();
		File file = new File("output_functional_revised.txt"); 
		FileUtils.write(file, "\n testTracker ="+(result!=null ? true : false), true);
	}
	/*
	 * testViewAllPage method is used to test whether redirecting to 
	 * viewAll page, expected 
	 */
	@Test
	void testViewAllPage() throws Exception {
		MvcResult result = this.mockmvc.perform(get("/viewlAll")).andExpect(view().name("viewall")).andReturn();
		File file = new File("output_functional_revised.txt"); 
		FileUtils.write(file, "\n testViewAllPage ="+(result!=null ? true : false), true);
	}
	@Test
	void testUpdatePage() throws Exception {
		MvcResult result = this.mockmvc.perform(get("/updateBill")).andExpect(view().name("index")).andReturn();
		File file = new File("output_functional_revised.txt"); 
		FileUtils.write(file, "\n testUpdatePage ="+(result!=null ? true : false), true);
	}
	
}
