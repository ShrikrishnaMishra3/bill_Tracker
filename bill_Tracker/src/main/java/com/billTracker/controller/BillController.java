package com.billTracker.controller;

import java.io.IOException;
import java.util.Date;
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
import com.examples.projects.model.Notes;

@Controller
public class BillController {

	@Autowired
	private BillService billService;

	@RequestMapping(value = "/")
	public ModelAndView showHomePage(HttpServletResponse response) throws IOException {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/updateBill", method = RequestMethod.POST)
	public ModelAndView updateBill(@ModelAttribute("bill") Billes bill) {
		billService.updateBill(bill);
		return new ModelAndView("tracker");
	}

	@RequestMapping(value = "/deletebill")
	public ModelAndView deleteNote(HttpServletRequest request) throws IOException {
		Long billid = Long.parseLong(request.getParameter("id"));
		billService.deleteBill(billid);
		List<Billes> billes = billService.getAllBillInfo();
		return new ModelAndView("tracker", "billes", billes);

	}

	@RequestMapping(value = "/editBill")
	public ModelAndView editBill() throws IOException {
		return new ModelAndView("editBill");

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

}
