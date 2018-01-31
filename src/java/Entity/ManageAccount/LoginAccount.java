package Entity.ManageAccount;

import Entity.UserAccount;
import java.io.IOException;
import java.util.Date;
import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Stateless
public class LoginAccount extends ManageAccount{
    protected ServletContext context;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UserAccount user = manager.getUser(request.getParameter("username"), request.getParameter("pass"));
        // Log-in is successful
        if(user != null){
            context = request.getServletContext();
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("lastLogged", user.getDate());
            Date date = new Date();
            user.setDate(date);
            manager.update(user);
            session.setAttribute("overAllUserCount", (Integer)context.getAttribute("overAllUserCount"));
            session.setAttribute("currentVisitorCount", (Integer)context.getAttribute("currentVisitorCount"));
            response.sendRedirect("LoggedIn/LoginSuccess.jsp");
        }   
        // Log-in is invalid
        else{
            request.setAttribute("invalid", "Either username or password does not match");
            request.getRequestDispatcher("loginPage").forward(request, response);
        }
    }
}
