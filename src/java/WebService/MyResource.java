package WebService;

import DAO.UserManager;
import Entity.UserAccount;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("account")
@Singleton
public class MyResource {
    private final UserManager manager;
    public MyResource(){
        manager = new UserManager();
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testMethod1(@QueryParam("name") String name){
        UserAccount user = manager.checkUserExists(name);
        if(user == null)
            return "Account does not exist";
        else
            return user.toString();
    }
}
