package ie.cit.gerry.controller;

import java.security.Principal;
import java.util.List;

import ie.cit.gerry.Customer;
import ie.cit.gerry.Delivery;
import ie.cit.gerry.Order;
import ie.cit.gerry.Product;
import ie.cit.gerry.dao.CustomerDao;
import ie.cit.gerry.dao.DeliveryDao;
import ie.cit.gerry.dao.OrderDao;
import ie.cit.gerry.dao.ProductDao;
import ie.cit.gerry.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/delivery")   
public class DeliveryController {
	
	@Autowired
	DeliveryDao deliveryDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	OrderDao orderDao;
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String formDelivery(Model model) {
		Delivery delivery = new Delivery();
		delivery.setDeliveryID(-1);
		model.addAttribute("delivery", delivery);
		return "deliveryaddress";
	}

		
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String addDelivery(@ModelAttribute("delivery") Delivery delivery, @ModelAttribute("product") Product product, 
			@ModelAttribute("order") Order order, Principal principal) {
		
		delivery.setDeliveryID(-1);
		
		String name = principal.getName(); //get logged in users userName
	    int id = userDao.getCustId(name).getId(); //get customer ID from name
	    
	    Customer customer = customerDao.getById(id); //get customer using id
		customer.setCreditLimit(customer.getCreditLimit() -order.getTotal()); 
	    customerDao.save(customer);
	    
		order.setOrderID(-1);
		
		orderDao.save(order);
		productDao.save(product);
		
		List<Order> orderList = orderDao.findByCustomerID(id);
		int size = (orderList.size() -1);
		Order o = orderList.get(size);
						
		delivery.setOrderID(o.getOrderID());
		
		deliveryDao.save(delivery);
		
		return "redirect:/home/";
	}

}
