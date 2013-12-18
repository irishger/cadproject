package ie.cit.gerry.controller;

import java.security.Principal;

import ie.cit.gerry.dao.CustomerDao;
import ie.cit.gerry.dao.DeliveryDao;
import ie.cit.gerry.dao.OrderDao;
import ie.cit.gerry.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	DeliveryDao deliveryDao;
	

	@RequestMapping(value="/home")
	public String login(Model model) {
		return "home";
	}
	

	// display logged in userName on home page
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String printWelcome(Model model, Principal principal) {
		
		String name = principal.getName(); //get logged in users userName
	    int id = userDao.getCustId(name).getId(); //get customer ID from name
	    
	    model.addAttribute("customer", customerDao.getById(id));
	    model.addAttribute("orders", orderDao.findByCustomerID(id));
	    model.addAttribute("delivery", deliveryDao.findByCustomerID(id) );    
	    return "home";
	}
	
}
