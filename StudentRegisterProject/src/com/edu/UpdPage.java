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
 * Servlet implementation class UpdPage
 */
@WebServlet("/UpdPage")
public class UpdPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdPage() {
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
		String sn=request.getParameter("name");
		Connection scon=DbConnector.getConnection();
		try {
			Statement st=scon.createStatement();
			String sql="select * from student where sid="+sid;
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				String upd="update student set sname='"+sn+"'where sid="+sid;
				int i=st.executeUpdate(upd);
				if(i>0)
				{
					out.println("<b>****Update successfully****</b>");
				}
				else
				{
					out.println("<b>----Not Update----</b>");
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
