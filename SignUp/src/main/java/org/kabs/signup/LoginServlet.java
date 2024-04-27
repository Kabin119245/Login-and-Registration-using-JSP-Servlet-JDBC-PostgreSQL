package org.kabs.signup;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        RequestDispatcher dispatcher = null;
        PrintWriter out = resp.getWriter();
        out.print("Working");

        String uemail = req.getParameter("username");
        String upwd = req.getParameter("password");


        //database code
        try{
            String url =  "jdbc:postgresql://localhost:5432/Users";
            String username = "postgres";
            String password = "2078";

           Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = con.prepareStatement("Select * from users where uemail= ? and upwd= ? ");

            pst.setString(1, uemail);
            pst.setString(2, upwd);

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                    session.setAttribute("name" , rs.getString("uname"));
                    dispatcher = req.getRequestDispatcher("index.jsp");


            } else {
                req.setAttribute("status","failed");
                dispatcher = req.getRequestDispatcher("login.jsp");
            }

            dispatcher.forward(req, resp);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        }

    }

