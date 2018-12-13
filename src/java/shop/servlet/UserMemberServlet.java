/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shop.business.UserMember;
import shop.database.UserMemberDAO;

@WebServlet(name = "UserMemberServlet", urlPatterns = {"/Login"})
public class UserMemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action;
        action = req.getParameter("action");
        if ("sign up".equalsIgnoreCase(action)) {
            try {
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String firstName = req.getParameter("firstName");
                String lastName = req.getParameter("lastName");
                String email = req.getParameter("email");
                String companyName = req.getParameter("companyName");
                String address1 = req.getParameter("address1");
                String address2 = req.getParameter("address2");
                String city = req.getParameter("city");
                String country = req.getParameter("country");
                UserMember member = new UserMember(0, username, password, firstName, lastName, email, companyName, address1, address2, city, country);
                UserMemberDAO.insert(member);
                String url = "/Login/signup.jsp";
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(req, resp);
            } catch (SQLException ex) {
                Logger.getLogger(UserMemberServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if ("sign in".equalsIgnoreCase(action)) {
            try {
                String username = req.getParameter("username");
                String password = req.getParameter("password");

                System.out.println(UserMemberDAO.checkUser(username, password));
                String url = "/Login/signin.jsp";
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(req, resp);
            } catch (SQLException ex) {
                Logger.getLogger(UserMemberServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String url = "/Login/signin.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
}
