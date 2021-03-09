package gigmate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * A class to represent a User.
 *
 * @author Sydney St. Clair
 */
@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "user_name")
    private String userName;
    private String pass;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Band band;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Venue venue;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private UserRole userRole;


    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userName the user name
     * @param pass      the pass
     */
    public User(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    /**
     * Instantiates a new User.
     *
     * @param id        the id
     * @param userName the user name
     * @param pass      the pass
     */
    public User(int id, String userName, String pass) {
        this.id = id;
        this.userName = userName;
        this.pass = pass;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPass() {
        return pass;
    }

    /**
     * Sets password.
     *
     * @param pass the password
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && userName.equals(user.userName) && pass.equals(user.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, pass);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}