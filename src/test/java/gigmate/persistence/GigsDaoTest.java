package gigmate.persistence;

import gigmate.entity.Band;
import gigmate.entity.Gigs;
import gigmate.entity.Venue;
import gigmate.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
}
