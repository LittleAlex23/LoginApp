package Entity.ManageAccount;

import Entity.UserAccount;
import java.io.IOException;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Stateless
public class DeleteAccount extends ManageAccount {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
        HttpSession session = request.getSession();
        UserAccount user = (UserAccount)session.getAttribute("user");
        manager.deleteUser(user);
        response.sendRedirect("TerminationConfirmed.html");
    }
}
