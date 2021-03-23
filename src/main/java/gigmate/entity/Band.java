package gigmate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// TODO figure out how to store pictures and audio

/**
 * A class to represent a Band
 *
 * @author Sydney St. Clair
 */
@Entity(name = "Band")
@Table(name = "band")
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String name;
    private String location;
    private String genera;
    private String email;
    @OneToMany(mappedBy = "openingBand", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Gigs> openingGigs = new HashSet<>();
    @OneToMany(mappedBy = "headlinerBand", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Gigs> headliningGigs = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users user;

    /**
     * Instantiates a new Band.
     */
    public Band() {
    }

    /**
     * Instantiates a new Band.
     *
     * @param name     the name
     * @param location the location
     * @param genera   the genera
     * @param email    the email
     * @param user     the user
     */
    public Band(String name, String location, String genera, String email, Users user) {
        this.name = name;
        this.location = location;
        this.genera = genera;
        this.email = email;
        this.user = user;
    }

    /**
     * Instantiates a new Band.
     *
     * @param id       the id
     * @param name     the name
     * @param location the location
     * @param genera   the genera
     * @param email    the email
     * @param user     the user
     */
    public Band(int id, String name, String location, String genera, String email, Users user) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.genera = genera;
        this.email = email;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets genera.
     *
     * @return the genera
     */
    public String getGenera() {
        return genera;
    }

    /**
     * Sets genera.
     *
     * @param genera the genera
     */
    public void setGenera(String genera) {
        this.genera = genera;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets opening gigs.
     *
     * @return the opening gigs
     */
    public Set<Gigs> getOpeningGigs() {
        return openingGigs;
    }

    /**
     * Sets opening gigs.
     *
     * @param openingGigs the opening gigs
     */
    public void setOpeningGigs(Set<Gigs> openingGigs) {
        this.openingGigs = openingGigs;
    }

    /**
     * Gets headlining gigs.
     *
     * @return the headlining gigs
     */
    public Set<Gigs> getHeadliningGigs() {
        return headliningGigs;
    }

    /**
     * Sets headlining gigs.
     *
     * @param headliningGigs the headlining gigs
     */
    public void setHeadliningGigs(Set<Gigs> headliningGigs) {
        this.headliningGigs = headliningGigs;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Band band = (Band) o;
        return id == band.id && name.equals(band.name) && location.equals(band.location) && genera.equals(band.genera) && email.equals(band.email) && user.equals(band.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, genera, email, user);
    }

    @Override
    public String toString() {
        return "Band{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", genera='" + genera + '\'' +
                ", email='" + email + '\'' +
                ", user=" + user +
                '}';
    }
}
