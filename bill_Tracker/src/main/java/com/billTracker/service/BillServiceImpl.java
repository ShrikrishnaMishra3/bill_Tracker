package com.billTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.billTracker.dao.BillDao;
import com.billTracker.model.Billes;

@Service
@Transactional
public class BillServiceImpl implements BillService{
	
	@Autowired
	private BillDao billDao;
		
	@Override
	public List<Billes> getAllBillInfo() {
		return billDao.getAllBilles();
	}

	@Override
	public boolean insertBill(Billes bill) {
		return billDao.insertBill(bill);
		
	}

	@Override
	public boolean deleteBill(Long id) {
		return billDao.deleteBill(id);
		
	}

	@Override
	public Billes getBillById(Long id) {
		return billDao.getBillById(id);
	}

	@Override
	public Long updateBill(Billes bill) {
		billDao.updateBill(bill);
		  return bill.getId();
	}
	

	
	

}
