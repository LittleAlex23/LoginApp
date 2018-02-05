package LoginServlet;

import Entity.ManageAccount.ExecutionFactory;
import Entity.ManageAccount.ManageAccount;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AccountServlet", urlPatterns = {"/AccountServlet"})
public class AccountServlet extends HttpServlet {
    @EJB
    ExecutionFactory factory;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if (session != null)
            session.invalidate();
        response.sendRedirect("/WebApp/loginPage");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String command = request.getParameter("execute");
        ManageAccount account = factory.getAccountCommand(command);
        account.execute(request, response);
    }
    @Override
    public String getServletInfo() {
        return "This servlet handle request regarding a user account";
    }
}
