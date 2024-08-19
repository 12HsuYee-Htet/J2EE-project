import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class BloodDonationServlet
 */
@WebServlet("/InformationServlet")
public class InformationServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out=response.getWriter();
    
    String firstname=request.getParameter("fname");
    String lastname=request.getParameter("Lname");
    String age=request.getParameter("age");
    String gender=request.getParameter("gender");
    String phone=request.getParameter("phone");
    String email=request.getParameter("email");
    String date=request.getParameter("date");
    
    out.println("First Name: "+ firstname + "</br>");
    out.println("Last Name: "+ lastname + "</br>");
    out.println("Age: "+ age + "</br>");
    out.println("Gender: "+ gender + "</br>");
    out.println("Phone: "+ phone + "</br>");
    out.println("Email: "+ email + "</br>");
    out.println("Date: "+ date + "</br>");
    
    try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Ready");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/uscp");
		System.out.println("Databased connected");
		
		PreparedStatement ps=con.prepareStatement("insert into donation(firstname,lastname, date,phone,email,yes,no,tattoo,piercing,dental");
		ps.setString(1, firstname);
		ps.setString(2, lastname);
		ps.setString(3, age);
		ps.setString(4, gender);
		ps.setString(5, phone);
		ps.setString(6, email);
		ps.setString(7, date);
		
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			out.println("First Name: "+ rs.getString(1) + "</br>");
		    out.println("Last Name: "+ rs.getString(2) + "</br>");
		    out.println("Age: "+ rs.getString(3) + "</br>");
		    out.println("Gender: "+ rs.getString(4) + "</br>");
		    out.println("Phone: "+ rs.getString(5) + "</br>");
		    out.println("Email: "+ rs.getString(6) + "</br>");
		    out.println("Date: "+ rs.getString(7) + "</br>");
		    
		}
		con.close();
  }catch(Exception e) {System.out.println(e);
  }
  }

}
