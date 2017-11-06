/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginServlet;

import DAO.UserManager;
import Entity.UserAccount;
import Entity.Validation;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alexandre
 */
@WebServlet(name = "AccountServlet", urlPatterns = {"/AccountServlet"})
public class AccountServlet extends HttpServlet {
    @EJB
    UserManager manager;
    
    @EJB
    Validation validation;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if (session != null)
            session.invalidate();
        response.sendRedirect("/WebApp/start");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("username");
        String pass = request.getParameter("pass");
        UserAccount user;
        
        // Attempt to log in
        if(request.getParameter("login") != null){
            user = manager.getUser(name, pass);
            // Log-in is successful
            if(user != null){
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                
                ServletContext ctx = getServletContext();
                session.setAttribute("overAllUserCount", (Integer)ctx.getAttribute("overAllUserCount"));
                session.setAttribute("currentVisitorCount", (Integer)ctx.getAttribute("currentVisitorCount"));
                
                response.sendRedirect("LoginSuccess.jsp");
            }   
            // Log-in is invalid
            else{
                request.setAttribute("invalid", "Either username or password does not match");
                request.getRequestDispatcher("start").forward(request, response);
            }
        }
        
        // Create a new account
        else if (request.getParameter("new_account") != null) {
            // Account does not exist so create a new one
            if(manager.checkUserExists(name) == null){
                if(!validation.isPassValid(pass))
                    request.setAttribute("invalidPassword", "invalid password");
                else{
                    manager.createNewUser(name, pass);
                    response.sendRedirect("/WebApp/start");
                    return;
                }
            }
            else
                request.setAttribute("accountExisted", "account already exists");
            request.getRequestDispatcher("CreateAccount.jsp").forward(request, response);
        }
        
        // Delete an account
        else if (request.getParameter("delete_account") != null) {
            HttpSession session = request.getSession();
            user = (UserAccount)session.getAttribute("user");
            manager.deleteUser(user);
            response.sendRedirect("TerminationConfirmed.html");
        }
        
        // Edit account
        else if (request.getParameter("edit_account") != null) {
            HttpSession session = request.getSession();
            user = (UserAccount)session.getAttribute("user");
            
            // Combine all request parameters into a String array
            Enumeration<String> paramList = request.getParameterNames();
            String[] paramValues = new String[4];
            paramValues[0] = user.getPassword();
            for(int i = 1 ; i < 4; i++)
                paramValues[i] = request.getParameter(paramList.nextElement());
            
            // Check whether the edited data are valid
            HashMap<Integer,String> message = validation.getResult(paramValues);
            if(!message.isEmpty()){
                request.setAttribute("errorMessage", message);
                request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
            }
            else{
                String newPassword = request.getParameter("new_password");
                String email = request.getParameter("new_email");
                
                // Empty strings imply no changes
                if(!newPassword.isEmpty()) user.setPassword(newPassword);
                if(!email.isEmpty()) user.setEmail(email);
                
                manager.update(user);
                response.sendRedirect("LoginSuccess.jsp");
            }
        }
        else if(request.getParameter("edit_text") != null){
            HttpSession session = request.getSession();
            user = (UserAccount)session.getAttribute("user");
            user.setDescription(request.getParameter("edit_text"));
             manager.update(user);
            response.sendRedirect("LoginSuccess.jsp");
        }
    }
    @Override
    public String getServletInfo() {
        return "This servlet handle request regarding a user account";
    }
    
}
