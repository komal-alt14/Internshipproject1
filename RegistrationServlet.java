package com.server.register;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the form data
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String duration = request.getParameter("duration");
        String batchTime = request.getParameter("batch time");
        String uniform = request.getParameter("uniform");
        String parentFullName = request.getParameter("full-name");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String[] packages = request.getParameterValues("package");

        // Convert package array to a comma-separated string
        StringBuilder packageBuilder = new StringBuilder();
        if (packages != null) {
            for (String pkg : packages) {
                packageBuilder.append(pkg).append(",");
            }
            // Remove the trailing comma
            packageBuilder.deleteCharAt(packageBuilder.length() - 1);
        }

        String packageSelected = packageBuilder.toString();

        // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/cricket_academy";
        String dbUser ="root"; // replace with your MySQL username
        String dbPassword = "komalvb123"; // replace with your MySQL password

        // SQL insert statement
        String sql = "INSERT INTO registrations (first_name, last_name, dob, gender, duration, batch_time, uniform, parent_full_name, mobile, email, address, package) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Establish a connection to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            // Create a PreparedStatement
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, dob);
            stmt.setString(4, gender);
            stmt.setString(5, duration);
            stmt.setString(6, batchTime);
            stmt.setString(7, uniform);
            stmt.setString(8, parentFullName);
            stmt.setString(9, mobile);
            stmt.setString(10, email);
            stmt.setString(11, address);
            stmt.setString(12, packageSelected);

            // Execute the statement
            int rows = stmt.executeUpdate();

            // Check if insertion was successful
            if (rows > 0) {
                response.getWriter().println("Registration successful!");
            } else {
                response.getWriter().println("Registration failed. Please try again.");
            }

            // Close the connection
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
response.getWriter().println("An error occured.Please try again");        }
    }
	
}