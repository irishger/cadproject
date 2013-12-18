package ie.cit.gerry;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeliveryDetailsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3258406085024010094L;
	
	// hard-coded test data
	ArrayList<Delivery> delivery = new ArrayList<Delivery>();

	@Override
	public void init() {
		
		Date date = new Date(2013-06-14);
		delivery.add(new Delivery(0,"John", "Mack", "99 The Street", "Ballytown", "Limerick", date ));
		delivery.add(new Delivery(1, "Jill", "O'Mahoney", "33 The Lane", "Kilthere", "Meath", date));

		// Add some more delivery info here...
	
	}
	
	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

		request.setAttribute("delivery", delivery);
		
		RequestDispatcher jsp = request.getRequestDispatcher("/deliverylist.jsp");
	      
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

		request.setAttribute("delivery", delivery);
		
		RequestDispatcher jsp = request.getRequestDispatcher("/deliverylist.jsp");
	      
		try {
			jsp.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
