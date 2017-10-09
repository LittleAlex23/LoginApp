package DAO;

import Entity.UserAccount;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.exception.ConstraintViolationException;

@Stateless
public class UserManager {
    static Session session;
    public UserManager(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    public UserAccount checkUserExists(String name){
        Query query = session.getNamedQuery("check");
        UserAccount user = (UserAccount)query.setString("username", name).uniqueResult();
        return user;
    }
    public void createNewUser(String name, String pass){
        UserAccount user = new UserAccount(name,pass);
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.flush();
    }
    public void deleteUser(UserAccount user){
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.flush();
    }
    public void update(UserAccount user){
    session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.flush();
    }
    @PreDestroy
    public void release(){
        if (session.isOpen())
            session.close();
        StandardServiceRegistryBuilder.destroy(session.getSessionFactory().getSessionFactoryOptions().getServiceRegistry());
    }
}
