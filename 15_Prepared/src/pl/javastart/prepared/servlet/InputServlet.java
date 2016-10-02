package pl.javastart.prepared.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
 
@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement prepStmt = null;
         
        try {
            Context initialContext = new InitialContext();
            Context envContext = (Context) initialContext
                    .lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/users");
            conn = ds.getConnection();
 
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            prepStmt = conn.prepareStatement(
            		"SELECT username, password FROM user WHERE username=? AND password=?;");
            prepStmt.setString(1, username);
            prepStmt.setString(2, password);
            System.out.println(prepStmt);
            resultSet = prepStmt.executeQuery();
             
            if(resultSet.next()) {
                String userFound = resultSet.getString("username");
                request.getSession().setAttribute("username", userFound);
                if("admin".equals(userFound)) {
                    request.getSession().setAttribute("privigiles", "all");
                } else{
                    request.getSession().setAttribute("privigiles", "view");
                }
            } else {
                request.getSession().setAttribute("username", "Nieznajomy");
                request.getSession().setAttribute("privigiles", "none");
            }
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                prepStmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
}