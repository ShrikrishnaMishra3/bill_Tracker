
package com.billTracker.functionalcases;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

import com.billTracker.dao.BillDao;
import com.billTracker.dao.BillDaoImpl;
import com.billTracker.model.Billes;
import com.billTracker.service.BillServiceImpl;
import com.billTracker.utiltestclass.MasterData;

import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class TestFunctional {

	@Mock
	private BillDaoImpl billDao;
	@InjectMocks
	private BillServiceImpl billServiceImpl;

	static {
		File file = new File("output_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("output_revised.txt"));
			} catch (IOException e) {

			}
		}
	}

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void test() {

	}

	@Test
	public void UpdateBill() throws Exception {
		Boolean flag = true;
		Billes bills = MasterData.getBillDetails();
		when(billServiceImpl.updateBill(bills)).thenReturn(bills.getId());
		Long testId = billServiceImpl.updateBill(bills);
		File file = new File("output_revised.txt");
		FileUtils.write(file, "\n UpdateBill = " + (testId == bills.getId() ? true : false), true);

	}

	@Test
	public void BillViewlAll() throws Exception {

		List<Billes> list = new ArrayList<>();
		List<Billes> noteList;
		list.add(new Billes());
		list.add(new Billes());

		when(billServiceImpl.getAllBillInfo()).thenReturn((List<Billes>) list);
		noteList = billServiceImpl.getAllBillInfo();
		File file = new File("output_revised.txt");
		FileUtils.write(file, "\n testViewAll = " + (noteList.size() == 2 ? true : false), true);
	}

	@Test
	public void DeleteBill() throws IOException {
		Boolean flag = true;
		when(billServiceImpl.deleteBill((long) 10008)).thenReturn(flag);
		boolean stats = billServiceImpl.deleteBill((long) 10008);
		File file = new File("output_revised.txt");
		FileUtils.write(file, "\n DeleteBill = " + (stats ? true : false), true);

	}

}
