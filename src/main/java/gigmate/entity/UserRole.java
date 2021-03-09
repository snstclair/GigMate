package gigmate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * A class to represent a User's roles.
 *
 * @author Sydney St. Clair
 */
@Entity(name = "UserRole")
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "user_name")
    private String userName;
    private String role;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Instantiates a new User role.
     */
    public UserRole() {
    }

    /**
     * Instantiates a new User role.
     *
     * @param userName the user name
     * @param role     the role
     * @param user     the user
     */
    public UserRole(String userName, String role, User user) {
        this.userName = userName;
        this.role = role;
        this.user = user;
    }

    /**
     * Instantiates a new User role.
     *
     * @param id       the id
     * @param userName the user name
     * @param role     the role
     * @param user     the user
     */
    public UserRole(int id, String userName, String role, User user) {
        this.id = id;
        this.userName = userName;
        this.role = role;
        this.user = user;
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
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return id == userRole.id && userName.equals(userRole.userName) && role.equals(userRole.role) && user.equals(userRole.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, role, user);
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                ", user=" + user +
                '}';
    }
}