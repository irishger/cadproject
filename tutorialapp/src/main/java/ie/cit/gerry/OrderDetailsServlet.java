package ie.cit.gerry;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * OrderServlet implementation class OrderDetailsServlet
 */
public class OrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = -3258406085024010094L;
    
	
		// hard-coded test data
		ArrayList<Order> orders = new ArrayList<Order>();

		@Override
		public void init() {
			
			// Add some orders here
		
		}
		
		@Override
	    public void doGet(HttpServletRequest request,
	            HttpServletResponse response)
	            throws ServletException, IOException {

			request.setAttribute("orders", orders);
			
			RequestDispatcher jsp = request.getRequestDispatcher("/orderList.jsp");
		      
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

			request.setAttribute("orders", orders);
			
			RequestDispatcher jsp = request.getRequestDispatcher("/orderList.jsp");
		      
			try {
				jsp.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
