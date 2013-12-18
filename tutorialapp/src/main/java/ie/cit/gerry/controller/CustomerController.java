package ie.cit.gerry.controller;

import ie.cit.gerry.Customer;
import ie.cit.gerry.dao.CustomerDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customer")    // base mapping on to which other mappings are added
public class CustomerController {
	
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String listCustomers(Model model) {		
		model.addAttribute("customers", customerDao.findAll());	
		return "customerlist";
	}

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String formCustomer(Model model) {
		Customer c = new Customer();
		c.setId(-1);
		model.addAttribute("customer", c);
		return "customerform";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute Customer customer) {
		customerDao.save(customer);
		return "redirect:/customer/";
	}

	@RequestMapping(value="/{id}/", method=RequestMethod.GET)
	public String addCustomer(Model model, @PathVariable int id) {
		model.addAttribute("customer", customerDao.getById(id));
		return "customerform";
	}
	

}