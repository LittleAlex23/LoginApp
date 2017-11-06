package LoginServlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class CountUserListener implements HttpSessionListener {
    ServletContext ctx = null;
    static int currentVisitorCount = 0, overAllUserCount = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessCreated method has been called in "
                + this.getClass().getName()
                );
        currentVisitorCount++;
        overAllUserCount++;
        
        ctx = se.getSession().getServletContext();
        ctx.setAttribute("currentVisitorCount", currentVisitorCount);
        ctx.setAttribute("overAllUserCount", overAllUserCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessiondestroyed method has been called in " 
                + this.getClass().getName());
        currentVisitorCount--;
        ctx.setAttribute("currentVisitorCount",currentVisitorCount);
    }
}
