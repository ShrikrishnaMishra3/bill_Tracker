
package com.billTracker.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity

@Table(name = "bill_infos")
public class Billes {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String billTitle;

	@Column
	private String category;

	@Column
	private double amount;

	@Override
	public String toString() {
		return "Billes [id=" + id + ", billTitle=" + billTitle + ", category=" + category + ", amount=" + amount
				+ ", dateOfEntry=" + dateOfEntry + ", dueDate=" + dueDate + ", paid=" + paid + ", unpaid=" + unpaid
				+ "]";
	}

	@Column
	private Date dateOfEntry;

	@Column
	private Date dueDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBillTitle() {
		return billTitle;
	}

	public void setBillTitle(String billTitle) {
		this.billTitle = billTitle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public  Date getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getUnpaid() {
		return unpaid;
	}

	public void setUnpaid(String unpaid) {
		this.unpaid = unpaid;
	}

	@Column
	private String paid;

	@Column
	private String unpaid;


	public boolean isActive;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}