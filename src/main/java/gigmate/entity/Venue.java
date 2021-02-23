package gigmate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// TODO add picture once figured out.

/**
 * A class to represent a Venue.
 *
 * @author Sydney St. Clair
 */
@Entity(name = "Venue")
@Table(name = "venue")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String name;
    private String location;

    @Column(name = "stage_type")
    private String stageType;
    private String email;
    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Gigs> gigs = new HashSet<>();

    /**
     * Instantiates a new Venue.
     */
    public Venue() {
    }

    /**
     * Instantiates a new Venue.
     *
     * @param name      the name
     * @param location  the location
     * @param stageType the stage type
     * @param email     the email
     */
    public Venue(String name, String location, String stageType, String email) {
        this();
        this.name = name;
        this.location = location;
        this.stageType = stageType;
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
     * Gets stage type.
     *
     * @return the stage type
     */
    public String getStageType() {
        return stageType;
    }

    /**
     * Sets stage type.
     *
     * @param stageType the stage type
     */
    public void setStageType(String stageType) {
        this.stageType = stageType;
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
        return "Venue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", stageType='" + stageType + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
