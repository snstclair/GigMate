package gigmate.persistence;


import gigmate.entity.Band;
import gigmate.entity.Venue;
import gigmate.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VenueDaoTest {
    GenericDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanVenueDb.sql");

        dao = new GenericDao(Venue.class);
    }

    @Test
    void getByIdSuccess() {
        Venue retrieveVenue = (Venue)dao.getById(2);
        Venue actualVenue = new Venue(2, "Keggers", "231 N Broadway, Green Bay, 54303", "Indoor small raised stage", "keggers@somewhere.com");
        assertNotNull(retrieveVenue);
        assertEquals(actualVenue, retrieveVenue);

    }

    @Test
    void getAllSuccess() {
        List<Venue> venues = dao.getAll();

        assertEquals(3, venues.size());
    }
}
