package Entity.ManageAccount;

import DAO.UserManager;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Local
public abstract class ManageAccount {
    @EJB
    UserManager manager;
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
