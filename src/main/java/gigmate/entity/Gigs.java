package gigmate.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * A Class to represent a Gig.
 *
 * @author Sydney St. Clair
 */
@Entity(name = "Gigs")
@Table(name = "gigs")
public class Gigs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @ManyToOne
    @JoinColumn(name = "opener_id")
    private Band openingBand;
    @ManyToOne
    @JoinColumn(name = "headliner_id")
    private Band headlinerBand;
    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;
    private LocalDate date;
    @Column(name = "start_time")
    private LocalTime startTime;


    /**
     * Instantiates a new Gigs.
     */
    public Gigs() {
    }

    /**
     * Instantiates a new Gigs.
     *
     * @param openingBand   the opening band
     * @param headlinerBand the headliner band
     * @param venue         the venue
     * @param date          the date
     * @param startTime     the start time
     */
    public Gigs(Band openingBand, Band headlinerBand, Venue venue, LocalDate date, LocalTime startTime) {
        this.openingBand = openingBand;
        this.headlinerBand = headlinerBand;
        this.venue = venue;
        this.date = date;
        this.startTime = startTime;
    }

    /**
     * Instantiates a new Gigs.
     *
     * @param id            the id
     * @param openingBand   the opening band
     * @param headlinerBand the headliner band
     * @param venue         the venue
     * @param date          the date
     * @param startTime     the start time
     */
    public Gigs(int id, Band openingBand, Band headlinerBand, Venue venue, LocalDate date, LocalTime startTime) {
        this.id = id;
        this.openingBand = openingBand;
        this.headlinerBand = headlinerBand;
        this.venue = venue;
        this.date = date;
        this.startTime = startTime;
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
     * Gets opening band.
     *
     * @return the opening band
     */
    public Band getOpeningBand() {
        return openingBand;
    }

    /**
     * Sets opening band.
     *
     * @param openingBand the opening band
     */
    public void setOpeningBand(Band openingBand) {
        this.openingBand = openingBand;
    }

    /**
     * Gets headliner band.
     *
     * @return the headliner band
     */
    public Band getHeadlinerBand() {
        return headlinerBand;
    }

    /**
     * Sets headliner band.
     *
     * @param headlinerBand the headliner band
     */
    public void setHeadlinerBand(Band headlinerBand) {
        this.headlinerBand = headlinerBand;
    }

    /**
     * Gets venue.
     *
     * @return the venue
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * Sets venue.
     *
     * @param venue the venue
     */
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets start time.
     *
     * @return the start time
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Sets start time.
     *
     * @param startTime the start time
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gigs gigs = (Gigs) o;
        return id == gigs.id && openingBand.equals(gigs.openingBand) && headlinerBand.equals(gigs.headlinerBand) && venue.equals(gigs.venue) && date.equals(gigs.date) && startTime.equals(gigs.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, openingBand, headlinerBand, venue, date, startTime);
    }

    @Override
    public String toString() {
        return "Gigs{" +
                "id=" + id +
                ", openingBand=" + openingBand +
                ", headlinerBand=" + headlinerBand +
                ", venue=" + venue +
                ", date=" + date +
                ", startTime=" + startTime +
                '}';
    }
}
