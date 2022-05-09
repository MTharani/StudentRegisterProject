package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DelPage
 */
@WebServlet("/DelPage")
public class DelPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelPage() {
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
			ResultSet rt=st.executeQuery(sql);
			if(rt.next())
			{
				String sql1="delete from student where sid="+sid;
				int i=st.executeUpdate(sql1);
				if(i>0)
				{
					out.println("<b>Delete sucessfully!</b>");
				}
				else
				{
					out.println("<b>Not Delete!</b>");
				}
			}
			else
			{
				out.println("<i>"+sid+": ID is Already Exist </i>");
			}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

}
