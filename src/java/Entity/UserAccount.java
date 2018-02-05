package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQuery(name="checkAccount", query="from UserAccount u where u.username = :username")
@Table(name="account")
public class UserAccount implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int ID;
    
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column(name="descr", length = 65535)
    private String description;
    @Column
    private String rank;
    
    @ManyToMany
    @JoinTable(
        name = "Player_Game",
        joinColumns = @JoinColumn(
                name = "ID",foreignKey=@ForeignKey(name="FK_Player_Game")),
        inverseJoinColumns = @JoinColumn(
                name = "gid"),
            inverseForeignKey = @ForeignKey(name = "FK_Game_Player")
    )
    Collection<Game> gameCollection = new LinkedList<>();
    
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="lastLogged")
    private Date date;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.trim();
    }
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public String toString(){
        return "Username: "+ username + 
                "\nRank: " + rank +
                "\nDescription: " + description;
    }
}
