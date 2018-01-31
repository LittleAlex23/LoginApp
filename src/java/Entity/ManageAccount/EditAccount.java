package Entity.ManageAccount;

import Entity.UserAccount;
import Entity.Validation;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Stateless
public class EditAccount extends ManageAccount{
    @EJB
    Validation validation;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        UserAccount user = (UserAccount)session.getAttribute("user");

        // Combine all request parameters into a String array
        Enumeration<String> paramList = request.getParameterNames();
        String[] paramValues = new String[3];
        paramValues[0] = user.getPassword();
        for(int i = 1 ; i < 3; i++)
            paramValues[i] = request.getParameter(paramList.nextElement());

        // Check whether the edited data are valid
        HashMap<Integer,String> message = validation.getResult(paramValues);
        if(!paramValues[0].equals(request.getParameter("old_password")) && !message.isEmpty()){
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
