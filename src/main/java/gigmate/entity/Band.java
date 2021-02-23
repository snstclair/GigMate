package gigmate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
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
    @OneToMany(mappedBy = "band", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Gigs> gigs = new HashSet<>();

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
     */
    public Band(String name, String location, String genera, String email) {
        this.name = name;
        this.location = location;
        this.genera = genera;
        this.email = email;
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
     * Gets gigs.
     *
     * @return the gigs
     */
    public Set<Gigs> getGigs() {
        return gigs;
    }

    /**
     * Sets gigs.
     *
     * @param gigs the gigs
     */
    public void setGigs(Set<Gigs> gigs) {
        this.gigs = gigs;
    }

    @Override
    public String toString() {
        return "Band{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", genera='" + genera + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
