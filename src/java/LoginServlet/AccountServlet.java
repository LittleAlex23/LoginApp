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
import java.io.PrintWriter;
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
    public void init(){
    } 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.setAttribute("name", request.getParameter("name"));
        response.sendRedirect("WEB-INF/LoginSuccess.jsp");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getParameter("name") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("username");
        String pass = request.getParameter("pass");
        UserAccount user;
        
        // Attempt to log in
        if(request.getParameter("login") != null){
            user = manager.checkUserExists(name);
            // Log in invalid
            if(user == null || !user.getPassword().equals(pass)){
                request.setAttribute("invalid", "Either username or password does not match");
                request.getRequestDispatcher("start").forward(request, response);
            }
          
            // Log-in success
            else{
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                
                ServletContext ctx = getServletContext();
                session.setAttribute("overAllUserCount", (Integer)ctx.getAttribute("overAllUserCount"));
                session.setAttribute("currentVisitorCount", (Integer)ctx.getAttribute("currentVisitorCount"));
                
                response.sendRedirect("LoginSuccess.jsp");
            }    
        }
        
        // Create a new account
        else if (request.getParameter("new_account") != null) {
            user = manager.checkUserExists(name);
            // Account does not exist so create a new one
            if(user == null){
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
            session.invalidate();
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
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet handle request regarding a user account";
    }// </editor-fold>
    
}
