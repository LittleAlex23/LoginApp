package Entity.ManageAccount;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ExecutionFactory {
    @EJB
    CreateAccount create;
    @EJB
    DeleteAccount delete;
    @EJB
    LoginAccount login;
    @EJB
    EditAccount edit;
    private static HashMap<String, ManageAccount> command;
    public ExecutionFactory(){
    }
    public ManageAccount getAccountCommand(String action){
        if(command == null){
            command = new HashMap<>();
            command.put("create account", create);
            command.put("confirm", delete);
            command.put("log_in", login);
            command.put("save", edit);
        }
        return command.get(action);
    }
}
