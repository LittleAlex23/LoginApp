package Entity.ManageAccount;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ExecutionFactory {
    @EJB
    CreateAccount create;
    @EJB
    DeleteAccount delete;
    @EJB
    LoginAccount login;
    @EJB
    EditAccount edit;
    public ManageAccount getAccountCommand(String action){
        switch (action) {
            case "create account":
                return create;
            case "confirm":
                return delete;
            case "log in":
                return login;
            case "save":
                return edit;
            default:
                break;
        }
        return null;
    }
}
