package ie.cit.gerry.controller;

import ie.cit.gerry.Product;
import ie.cit.gerry.dao.CustomerDao;
import ie.cit.gerry.dao.OrderDao;
import ie.cit.gerry.dao.ProductDao;
import ie.cit.gerry.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/product")    // base mapping
public class ProductController {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	OrderDao orderDao;
	
	//get method lists all products
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String listProducts(Model model) {

		model.addAttribute("products", productDao.findAll());	
		return "productList";
	}
	
	//get method adds empty product to product form admin access only
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String formProduct(Model model) {
		Product p = new Product();
		p.setSku(-1);
		model.addAttribute("product", p);
		return "productform";
	}
	
	//post method to add product from from to database admin access only
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String addProduct(@ModelAttribute Product product) {
		productDao.add(product);
		return "redirect:/product/";
	}
	
	//get method list product by sku in url address
	@RequestMapping(value="/{sku}",  method=RequestMethod.GET)
	public String ListProducts(@PathVariable("sku") int sku, Model model) {
		model.addAttribute("x",productDao.getBySku(sku));
		return "sku";
	}
	
	//get method for sku search
	@RequestMapping(value="/sku/",  method=RequestMethod.GET)
	public String productSearchPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "searchbysku";
	}
	
	//post method product by sku search
	@RequestMapping(value="/sku/",  method=RequestMethod.POST)
	public String productSearch(@ModelAttribute Product product, Model model) {
		int sku = product.getSku();
		model.addAttribute("x",productDao.getBySku(sku));
		return "sku";
	}

}
