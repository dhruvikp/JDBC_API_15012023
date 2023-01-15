package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.util.DBConnection;

/**
 * Servlet implementation class ProductInfoServlet
 */
@WebServlet("/productInfo")
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Product Information :</h1>");
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();

		if (connection != null) {
			out.println("<table>");
			out.println("<tr>");
			out.println("<td> Product ID </td>");
			out.println("<td> Product Name </td>");
			out.println("<td> Product Price </td>");
			out.println("<td> Date </td>");
			out.println("</tr>");

			try {
				// STEP 3: Gets statement object
				Statement stmt = connection.createStatement();

				ResultSet rs = stmt.executeQuery("select * from eproduct");
				while (rs.next()) {
					out.println("<tr>");
					Integer productId = rs.getInt(0);
					String productName = rs.getString(1);
					Double productPrice = rs.getDouble(2);
					Date date = rs.getTimestamp(3);

					out.println("<td>" + productId + "</td>");
					out.println("<td>" + productName + "</td>");
					out.println("<td>" + productPrice + "</td>");
					out.println("<td>" + date + "</td>");
					out.println("</tr>");
				}
				out.println("</table>");

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			out.println("DB Connection problem, Please contact to administrator!");
		}

		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
