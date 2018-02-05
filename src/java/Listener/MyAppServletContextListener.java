package Listener;


import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyAppServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("WebApp is starting");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("WebApp is destroyed");
    }
}
