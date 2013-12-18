package ie.cit.gerry;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerDetailsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3258406085024010094L;
	
	// hard-coded test data
	ArrayList<Customer> customers = new ArrayList<Customer>();

	@Override
	public void init() {
		customers.add(new Customer("John", "Mack", "99 The Street", "Ballytown", "Limerick", 20000.0));
		customers.add(new Customer("Jill", "O'Mahoney", "33 The Lane", "Kilthere", "Meath", 53257.43));

		// Add some more delivery here...
	
	}
	
	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

		request.setAttribute("delivery", customers);
		
		RequestDispatcher jsp = request.getRequestDispatcher("/customerlist.jsp");
	      
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

		request.setAttribute("delivery", customers);
		
		RequestDispatcher jsp = request.getRequestDispatcher("/customerlist.jsp");
	      
		try {
			jsp.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
