package ie.cit.gerry;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductDetailsServlet extends HttpServlet {
	
private static final long serialVersionUID = -3258406085024010094L;
	
	// hard-coded test data
	ArrayList<Product> products = new ArrayList<Product>();

	@Override
	public void init() {
		
		// Add some product details here...
	
	}
	
	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

		request.setAttribute("products", products);
		
		RequestDispatcher jsp = request.getRequestDispatcher("/productList.jsp");
	      
		try {
			jsp.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

		request.setAttribute("products", products);
		
		RequestDispatcher jsp = request.getRequestDispatcher("/productList.jsp");
	      
		try {
			jsp.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
