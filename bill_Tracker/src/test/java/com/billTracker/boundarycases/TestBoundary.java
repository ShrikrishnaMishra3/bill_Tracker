
package com.billTracker.boundarycases;

import static org.mockito.Mockito.when;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.billTracker.dao.BillDao;
import com.billTracker.dao.BillDaoImpl;
import com.billTracker.model.Billes;
import com.billTracker.service.BillServiceImpl;
import com.billTracker.utiltestclass.MasterData;

public class TestBoundary {

	static {
		System.out.println("static  line");
		File file = new File("output_boundary_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("output_boundary_revised.txt"));
			} catch (IOException e) {

			}
		}
	}

	@Before
	public void init() {
		System.out.println("first line");
		MockitoAnnotations.initMocks(this);
		System.out.println("Lsast line");
	}

	@Test
	public void testBillTitleLength() throws Exception {
		Billes bills = MasterData.getBillDetails();
		bills.getBillTitle();
		int maxChar = 5;
		boolean billTittleLength = ((bills.getBillTitle().length()) >= maxChar);
		File file = new File("output_boundary_revised.txt");
		FileUtils.write(file, "\ntestbillTittleLength=" + (billTittleLength ? true : false), true);
	}

	@Test
	public void testActiveUser() throws Exception {
		Billes bills = MasterData.getBillDetails();
		bills.isActive();
		boolean result = true;
		File file = new File("output_boundary_revised.txt");
		FileUtils.write(file, "\ntestActiveBills=" + (result ? true : false), true);
	}
}
