package com.visog.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.visog.util.Admin;
import com.visog.util.User;

@WebServlet(name = "Admin", urlPatterns = { "/Admin" })
public class AdminController extends HttpServlet {
	
	static Logger logger = Logger.getLogger(AdminController.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
       
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String errorMsg = null;
		if(email == null || email.equals("")){
			errorMsg ="User Email can't be null or empty";
		}
		if(pass == null || pass.equals("")){
			errorMsg = "Password can't be null or empty";
		}
		if(errorMsg != null){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>"+errorMsg+"</font>");
			rd.include(request, response);
		}else{
			
			Connection con = (Connection) getServletContext().getAttribute("DBConnection");
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement("Select email,pass from login where email=? and pass=? limit 1");
				ps.setString(1, email);
				ps.setString(2, pass);
				rs = ps.executeQuery();
				
				if(rs != null){
					rs.next();
					Admin admin = new Admin(rs.getString("email"),rs.getString("pass"));
					logger.info("User found with details="+admin);
					HttpSession session = request.getSession();
					session.setAttribute("Admin", admin);
					response.sendRedirect("admin.jsp");;
				}else{
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin.html");
					PrintWriter out= response.getWriter();
					logger.error("User not found with email="+email);
					out.println("<font color=red>No user found with given email id, please register first.</font>");
					rd.include(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("Database connection problem");
				throw new ServletException("DB Connection problem.");
			}finally{
				try {
					rs.close();
					ps.close();
				} catch (SQLException e) {
					logger.error("SQLException in closing PreparedStatement or ResultSet");;
				}

	}
		}}}
