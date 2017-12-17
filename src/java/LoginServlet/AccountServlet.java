package LoginServlet;

import DAO.UserManager;
import Entity.ManageAccount.ExecutionFactory;
import Entity.ManageAccount.ManageAccount;
import Entity.Note;
import Entity.UserAccount;
import Entity.Validation;
import java.io.IOException;
import java.util.Date;
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
    Validation validation;

    @EJB
    ExecutionFactory factory;
    
    @EJB
    UserManager manager;
    
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
        UserAccount user;
        String command = request.getParameter("execute");
        if(command != null){
            ManageAccount account = factory.getAccountCommand(command);
            if(command.equals("log in"))
                account.setContext(getServletContext());
            account.execute(request, response);
        }
        else if(request.getParameter("edit_descr") != null){
            HttpSession session = request.getSession();
            user = (UserAccount)session.getAttribute("user");
            user.setDescription(request.getParameter("edit_descr"));
            manager.update(user);
        }
        else if(request.getParameter("c1") != null){
            HttpSession session = request.getSession();
            user = (UserAccount)session.getAttribute("user");
            Note n = new Note();
            n.setDescr(request.getParameter("c1"));
            n.setUserID(user.getID());
            n.setDate(new Date());
            user.getNote().add(n);
            manager.save(user, n);
        }
    }
    @Override
    public String getServletInfo() {
        return "This servlet handle request regarding a user account";
    }
}
