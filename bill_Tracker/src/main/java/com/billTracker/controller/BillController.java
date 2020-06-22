package com.billTracker.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.billTracker.model.Billes;
import com.billTracker.service.BillService;

@Controller
public class BillController {

	@Autowired
	private BillService billService;

	@RequestMapping(value = "/")
	public ModelAndView showHomePage(HttpServletResponse response) throws IOException {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/addBill")
	public ModelAndView addNote(HttpServletResponse response) throws IOException {
		return new ModelAndView("addBill");
	}

	@RequestMapping(value = "/deletebill")
	public ModelAndView deleteNote(HttpServletRequest request) throws IOException {
		Long billid = Long.parseLong(request.getParameter("id"));
		billService.deleteBill(billid);
		List<Billes> billes = billService.getAllBillInfo();
		return new ModelAndView("tracker", "billes", billes);

	}

	@RequestMapping(value = "/editBill")
	public ModelAndView editBill(HttpServletRequest request) throws IOException {
		System.out.println("EditBillMetod");
		Long id = Long.parseLong(request.getParameter("id"));
		System.out.println((request.getParameter("id")));
		Billes billes = billService.getBillById(id);
		System.out.println(billes.getBillTitle());
		return new ModelAndView("update", "bill", billes);
	}

	@RequestMapping(value = "/tracker")
	public ModelAndView Tracker(HttpServletResponse response) throws IOException {
		List<Billes> billes = billService.getAllBillInfo();
		return new ModelAndView("tracker", "billes", billes);
	}

	@RequestMapping(value = "/viewlAll")
	public ModelAndView viewlAll(HttpServletResponse response) throws IOException {
		List<Billes> billes = billService.getAllBillInfo();
		return new ModelAndView("viewall", "billes", billes);

	}

	@RequestMapping(value = "/updateBill", method = RequestMethod.POST)
	public ModelAndView updateBill(@ModelAttribute("bill") Billes bill) {
		billService.updateBill(bill);
		return new ModelAndView("redirect:/tracker");
	}

	@RequestMapping(value = "/addBills")
	public ModelAndView addNewBill(HttpServletRequest request) throws Exception {
		System.out.println("sidj");
		String billTitle = request.getParameter("billTitle");
		String category = request.getParameter("category");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String date1 = request.getParameter("dateOfEntry");
		Date dateOfEntry = Date.valueOf(date1);

		String Date2 = request.getParameter("dueDate");
		Date dueDate = Date.valueOf(Date2);
		String paid = request.getParameter("paid");
		String unpaid = request.getParameter("unpaid");

		Billes billes = new Billes();
		billes.setBillTitle(billTitle);
		billes.setCategory(category);
		billes.setAmount(amount);

		billes.setDateOfEntry(dateOfEntry);
		billes.setDueDate(dueDate);

		billes.setPaid(paid);
		billes.setUnpaid(unpaid);
		billService.insertBill(billes);

		return new ModelAndView("redirect:/tracker");
	}

}
