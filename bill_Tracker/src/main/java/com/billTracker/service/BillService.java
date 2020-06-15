package com.billTracker.service;

import java.util.List;


import com.billTracker.model.Billes;

public interface BillService {
	
	public List<Billes> getAllBillInfo();
	
	public boolean insertBill(Billes bill);
		
	public boolean deleteBill(Long id);

	public Billes getBillById(Long id);
	
	public Long updateBill(Billes bill);
	
	

}
