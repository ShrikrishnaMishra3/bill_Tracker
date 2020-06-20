package com.billTracker.dao;

import java.util.List;

import com.billTracker.model.Billes;

public interface BillDao {
	
public List<Billes> getAllBillInfo();
	
	public boolean insertBill(Billes bill);
	public boolean deleteBill(Long id);
	public Billes getBillById(Long id);
	public List<Billes> getAllBilles();
	public Long updateBill(Billes bill);
	
		
}
