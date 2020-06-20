package com.billTracker.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.billTracker.model.Billes;

@Repository
public class BillDaoImpl implements BillDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Billes> getAllBilles() {
		return sessionFactory.getCurrentSession().createQuery("from Billes").getResultList();
	}

	@Override
	public boolean insertBill(Billes bill) {
		Serializable serializable = sessionFactory.getCurrentSession().save(bill);
		if(serializable!=null)
			return true;
		else
			return false;
		
	}

	@Override
	public boolean deleteBill(Long id) {
		Billes bill = (Billes) sessionFactory.getCurrentSession().load(Billes.class, id);
		if (null != bill) {
			this.sessionFactory.getCurrentSession().delete(bill);
		   }
				return true;
			}

	@Override
	public Billes getBillById(Long id) {
		System.out.println("Dao of getBIllBy iD");
		Billes bill=  sessionFactory.getCurrentSession().load(Billes.class, id);
		System.out.println(bill);
		return bill;

	}

	@Override
	public List<Billes> getAllBillInfo() {
		return sessionFactory.getCurrentSession().createQuery("from Billes").getResultList();
	}

	@Override
	public Long updateBill(Billes bill) {
			sessionFactory.getCurrentSession().update(bill);
			return bill.getId();
	}

}
