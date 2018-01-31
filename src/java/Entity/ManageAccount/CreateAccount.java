package Entity.ManageAccount;

import Entity.Validation;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Stateless
public class CreateAccount extends ManageAccount{
    @EJB
    Validation validation;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("username");
        String pass = request.getParameter("pass");
        
        // Account already exists
        if(manager.checkUserExists(name) != null){
            request.setAttribute("accountExisted", "account already exists");
            request.getRequestDispatcher("CreateAccount.jsp").forward(request, response);
        }
        else{
            boolean isUserNameValid = validation.isUsernameValid(name);
            boolean isPasswordValid = validation.isPassValid(pass);
            
            // username and password are valid
            if(isUserNameValid && isPasswordValid){
                manager.createNewUser(name, pass);
                response.sendRedirect("/WebApp/loginPage");
            }
            else{
                // either the username or the password is invalid
                if(!isUserNameValid)
                    request.setAttribute("nameTooLong", "the length must be between 3 and 12 inclusive");
                if(!isPasswordValid)
                    request.setAttribute("invalidPassword", "invalid password");
               request.getRequestDispatcher("CreateAccount.jsp").forward(request, response);
            }
        }
    }
}
