package ie.cit.gerry.controller;

import java.security.Principal;
import java.sql.Date;

import ie.cit.gerry.Delivery;
import ie.cit.gerry.Order;
import ie.cit.gerry.Product;
import ie.cit.gerry.dao.CustomerDao;
import ie.cit.gerry.dao.DeliveryDao;
import ie.cit.gerry.dao.OrderDao;
import ie.cit.gerry.dao.UserDao;
import ie.cit.gerry.dao.ProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/order")    // base mapping
public class OrderController {
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	DeliveryDao deliveryDao;
	
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String listOrders(Model model) {

		model.addAttribute("orders", orderDao.findAll());
		model.addAttribute("delivery", deliveryDao.findAll());
		model.addAttribute("customer", customerDao.findAll());
		return "orderList";
	}

	//add an order
	@RequestMapping(value="/add/{sku}", method=RequestMethod.GET)
	public String formOrder(@PathVariable("sku") int sku,Model model) {
		Order order = new Order();
		model.addAttribute("order", order);
		model.addAttribute("product", productDao.getBySku(sku));
		return "orderform";
	}
		
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String setDeliveryAddress(@ModelAttribute("order") Order order, 
			@ModelAttribute("product") Product product, Model model, Principal principal) {
		
		String name = principal.getName();
		int id = userDao.getCustId(name).getId(); 
		
		order.setSku(product.getSku());
		order.setCustomerID(id);
		
		product.setStockLevel(product.getStockLevel() - order.getQuantity());
		double total = (product.getPricePerUnit() * order.getQuantity());
		order.setTotal(total);
		
		Delivery delivery = new Delivery();
		
		java.util.Date today = new java.util.Date();
		Date date = new Date(today.getTime());
		delivery.setDeliveryDate(date);
		
		model.addAttribute("delivery", delivery);
		model.addAttribute("order", order);
		model.addAttribute("product", product);
		
		return "deliveryaddress";
	}
	
	//get order by order id
	@RequestMapping(value="/{orderID}")
	public String ListOrders(@PathVariable("orderID") int orderID,
			Model model) {
		model.addAttribute("order",orderDao.getByOrderID(orderID));
		return "orderID";
	}
	
}
