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
        Driver driver;
        try {
            driver = (Driver) DriverManager.getDriver("jdbc:mysql://localhost:3306/userDB?zeroDateTimeBehavior=convertToNull");
            DriverManager.deregisterDriver(driver);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("WebApp is destroyed");
    }
}
