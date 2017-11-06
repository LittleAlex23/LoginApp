package Entity.ManageAccount;

import DAO.UserManager;
import Entity.Validation;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Local
public abstract class ManageAccount {
    @EJB
    UserManager manager;
    @EJB
    Validation validation;
    
    protected ServletContext context;
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public void setContext(ServletContext context) {
        this.context = context;
    }
    
    
}
