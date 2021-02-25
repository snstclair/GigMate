package gigmate.persistence;

import gigmate.entity.Band;
import gigmate.entity.Gigs;
import gigmate.entity.Venue;
import gigmate.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class GigsDaoTest {
    GenericDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanGigsDb.sql");

        dao = new GenericDao(Gigs.class);

    }

    @Test
    void getByIdSuccess() {
        Gigs retrieveGig = (Gigs)dao.getById(2);
        Band band = new Band(1, "Sky Urchin", "Madison, WI", "Indie Rock", "skyurchin@somewhere.com");
        Venue venue = new Venue(1, "Pooleys", "5441 High Crossing Blvd, Madison, WI 53718", "Outdoor Patio", "pooleys@somewhere.com");


        Gigs actualGig = new Gigs(2, band, venue, LocalDate.parse("2021-06-17"));
        assertNotNull(retrieveGig);
        assertEquals(actualGig, retrieveGig);

    }

    @Test
    void getAllSuccess() {
        List<Gigs> gigs = dao.getAll();

        assertEquals(4, gigs.size());

    }

    @Test
    void insertSuccess() {
        GenericDao bandDao = new GenericDao(Band.class);
        GenericDao venueDao = new GenericDao(Venue.class);

        Band band = (Band)bandDao.getById(2);
        Venue venue = (Venue)venueDao.getById(1);

        Gigs newGig = new Gigs(band, venue, LocalDate.parse("2021-08-18"));

        int id = dao.insert(newGig);

        Gigs insertedGig = (Gigs)dao.getById(id);
        assertEquals(newGig, insertedGig);
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }
}
