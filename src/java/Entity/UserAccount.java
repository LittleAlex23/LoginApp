package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="check", query="from UserAccount u where u.username = :username")
@Table(name="account")
public class UserAccount implements Serializable {
    @Id
    private String username;
    @Column
    private String password;
    @Column
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public UserAccount(){
    }
    public UserAccount(String name, String password) {
        this.username = name;
        this.password = password;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
