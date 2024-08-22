

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class InformationServlet
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		  String firstname = request.getParameter("Fname");
          String lastname = request.getParameter("Lname");
          String age = request.getParameter("age");
          String gender = request.getParameter("gender");
          String phone = request.getParameter("phone");
          String email = request.getParameter("email");
          String date = request.getParameter("date");
          
          response.setContentType("text/html");
          PrintWriter pw=response.getWriter();
          pw.println("First Name: " + firstname + "<br>");
          pw.println("Last Name: " + lastname + "<br>");
          pw.println("Age: " + age + "<br>");
          pw.println("Gender: " + gender + "<br>");
          pw.println("Phone: " + phone + "<br>");
          pw.println("Email: " + email + "<br>");
          pw.println("Date: " + date + "<br>");

          try {
              Class.forName("com.mysql.jdbc.Driver");
              System.out.println("Driver is Ready");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BeautyClinic", "root", "");
              System.out.println("Database connected");
              
                   PreparedStatement ps = con.prepareStatement(
                       "INSERT INTO clinic (firstname, lastname, age, gender, phone, email, date) VALUES (?, ?, ?, ?, ?, ?, ?)"); 
                  ps.setString(1, firstname);
                  ps.setString(2, lastname);
                  ps.setString(3, age);
                  ps.setString(4, gender);
                  ps.setString(5, phone);
                  ps.setString(6, email);
                  ps.setString(7, date);
                  ps.executeUpdate();
                  
                  pw.println("<h1>Retrieve from Database</br></h1>");
                  PreparedStatement ps1=con.prepareStatement("select * from clinic" );
                  ResultSet rs= ps1.executeQuery();
                  while(rs.next()) {
                  	pw.println("First Name :"+rs.getString(1)+"<br/>");
                  	pw.println("Last Name :"+rs.getString(2)+"<br/>");
                  	pw.println("Age :"+rs.getString(3)+"<br/>");
                  	pw.println("Gender :"+rs.getString(4)+"<br/>");
                  	pw.println("Phone :"+rs.getString(5)+"<br>");
                  	pw.println("Email :"+rs.getString(6)+"<br/>");
                  	pw.println("Date :"+rs.getString(7)+"<br>");
                  }
               con.close();
          }
          catch(Exception e) {System.out.println(e);}
  }
  }

