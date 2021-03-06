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
    private Band band;
    @ManyToOne
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
     * @param band      the band
     * @param venue     the venue
     * @param date      the date
     * @param startTime the start time
     */
    public Gigs(Band band, Venue venue, LocalDate date, LocalTime startTime) {
        this.band = band;
        this.venue = venue;
        this.date = date;
        this.startTime = startTime;
    }

    /**
     * Instantiates a new Gigs.
     *
     * @param id        the id
     * @param band      the band
     * @param venue     the venue
     * @param date      the date
     * @param startTime the start time
     */
    public Gigs(int id, Band band, Venue venue, LocalDate date, LocalTime startTime) {
        this.id = id;
        this.band = band;
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
     * Gets band.
     *
     * @return the band
     */
    public Band getBand() {
        return band;
    }

    /**
     * Sets band.
     *
     * @param band the band
     */
    public void setBand(Band band) {
        this.band = band;
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
        return id == gigs.id && band.equals(gigs.band) && venue.equals(gigs.venue) && date.equals(gigs.date) && startTime.equals(gigs.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, band, venue, date, startTime);
    }

    @Override
    public String toString() {
        return "Gigs{" +
                "id=" + id +
                ", band=" + band +
                ", venue=" + venue +
                ", date=" + date +
                ", startTime=" + startTime +
                '}';
    }
}
