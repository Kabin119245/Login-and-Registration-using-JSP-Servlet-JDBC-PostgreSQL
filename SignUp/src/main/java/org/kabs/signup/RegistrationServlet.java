package org.kabs.signup;

import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        PrintWriter out = response.getWriter();
        out.println("Working");

        String uname = request.getParameter("name");
        String uemail = request.getParameter("email");
        String upwd = request.getParameter("password");
        String umobile = request.getParameter("contact");
        RequestDispatcher dispatcher = null;

        //for postgresql
        String url =  "jdbc:postgresql://localhost:5432/Users";
        String username = "postgres";
        String password = "2078";


        out.println(uname +  uemail +  upwd + umobile );
        //now inserting those data in the database, i am using postgresql
        Connection con  = null;
        try{
            //no need to load driver explicityly
            Class.forName("org.postgresql.Driver");
             con = DriverManager.getConnection(url, username, password);

            PreparedStatement st =  con.prepareStatement("insert into users(uname, upwd, uemail,  umobile) values (?,?,?,?)");
            st.setString(1,uname);
            st.setString(2,upwd);
            st.setString(3,uemail);
            st.setString(4,umobile);
            int rowCount = st.executeUpdate();

            dispatcher = request.getRequestDispatcher("registration.jsp");

            if(rowCount > 0) {
                    request.setAttribute("status","success");

            } else {
                request.setAttribute("status","success");
            }


            dispatcher.forward(request,response);


        }
        catch(ClassNotFoundException | SQLException | ServletException e ) {
            System.out.println(e);

        }

        finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }




    }
}
