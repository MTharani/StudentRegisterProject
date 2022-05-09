package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisPage
 */
@WebServlet("/DisPage")
public class DisPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int sid=Integer.parseInt(request.getParameter("id"));
		
		Connection scon=DbConnector.getConnection();
		try {
			Statement st=scon.createStatement();
			String sql="select * from student where sid="+sid;
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				out.println("<!DOCTYPE Html>");
				out.println("<head><title>Student Information</title></head>");
				out.println("<body><p><i><h2>Particular Student Information</h2></i></p>");
				out.println("<table border='3'>");
				out.println("<tr>");
				out.println("<th>ID</th>");
				out.println("<th>Name</th>");
				out.println("<th>Password</th>");
				out.println("<th>Age</th>");
				out.println("<th>fees</th>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>"+rs.getString("sid")+"</td>");
				out.println("<td>"+rs.getString("sname")+"</td>");
				out.println("<td>"+rs.getString("spass")+"</td>");
				out.println("<td>"+rs.getString("sage")+"</td>");
				out.println("<td>"+rs.getString("sfee")+"</td>");
			    out.println("</tr>");
			}
			else
			{
				out.println("<i>"+sid+": ID is Not Found </i>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		
		 }catch(Exception e)
		 {
			e.printStackTrace();
		 }
	}

}
