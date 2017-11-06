package DAO;

import Entity.UserAccount;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@Stateless
public class UserManager {
    static Session session;
    public UserManager(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    public UserAccount checkUserExists(String name){
        Query query = session.getNamedQuery("checkAccount");
        UserAccount user = (UserAccount)query.setString("username", name).uniqueResult();
        return user;
    }
    public UserAccount getUser(String name, String password){
        UserAccount user = checkUserExists(name);
       if(user == null || !user.getPassword().equals(password))
            return null;
        else 
            return user;
    }
    public void createNewUser(String name, String pass){
        UserAccount user = new UserAccount(name,pass);
        session.beginTransaction();
        session.save(user);
        commitUser();
    }
    public void deleteUser(UserAccount user){
        session.beginTransaction();
        session.delete(user);
        commitUser();
    }
    public void update(UserAccount user){
        session.beginTransaction();
        session.update(user);
        commitUser();
    }
    @PreDestroy
    public void release(){
        if (session.isOpen())
            session.close();
        StandardServiceRegistryBuilder.destroy(session.getSessionFactory().getSessionFactoryOptions().getServiceRegistry());
    }
    private void commitUser(){
        session.getTransaction().commit();
        session.flush();
    }
}
