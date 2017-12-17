package WebService;

import DAO.UserManager;
import Entity.UserAccount;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("/")
@ApplicationPath("webapi")
public class MyWebService extends Application{
    private final UserManager manager;
    public MyWebService(){
        manager = new UserManager();
    }
    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String testMethod1(@PathParam("name") String name){
        UserAccount user = manager.checkUserExists(name);
        if(user == null)
            return "Account does not exist";
        else
            return user.toString();
    }
}
