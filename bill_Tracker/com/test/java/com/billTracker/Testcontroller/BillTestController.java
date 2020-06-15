
package com.billTracker.Testcontroller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.billTracker.controller.BillController;
import com.billTracker.service.BillService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class BillTestController {

	@InjectMocks
	private BillController billController;

	private MockMvc mockMvc;

	@Autowired
	private BillService Service;

	@Before
	public void setup() {
		System.out.println("Before Every method....");
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(billController).build();
	}

	@Test
	public void testviewlAll() throws Exception {
		this.mockMvc.perform(get("/viewlAll")).andExpect(status().isOk()).andExpect(view().name("billes"));
	}

	@Test
	public void testTracker() throws Exception {
		this.mockMvc.perform(get("/tracker")).andExpect(status().isOk()).andExpect(view().name("billes"));

	}
}
