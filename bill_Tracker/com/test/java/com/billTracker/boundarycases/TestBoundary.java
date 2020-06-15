package com.billTracker.boundarycases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.billTracker.model.Billes;
import com.billTracker.utiltestclass.MasterData;

public class TestBoundary {

	static {
		File file = new File("output_boundary_revised.txt");		
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("output_boundary_revised.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
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