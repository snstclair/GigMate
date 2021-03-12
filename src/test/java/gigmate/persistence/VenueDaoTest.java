package gigmate.persistence;

import gigmate.entity.Users;
import gigmate.entity.Venue;
import gigmate.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VenueDaoTest {
    GenericDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDb.sql");

        dao = new GenericDao(Venue.class);
    }

    @Test
    void getByIdSuccess() {

        GenericDao userDao = new GenericDao(Users.class);
        Users venueUser = (Users)userDao.getById(5);


        Venue retrieveVenue = (Venue)dao.getById(2);
        Venue actualVenue = new Venue(2, "Keggers", "231 N Broadway, Green Bay, 54303", "Indoor small raised stage", "keggers@somewhere.com", venueUser);
        assertNotNull(retrieveVenue);
        assertEquals(actualVenue, retrieveVenue);

    }

    @Test
    void getAllSuccess() {
        List<Venue> venues = dao.getAll();

        assertEquals(3, venues.size());
    }

    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(Users.class);
        Users venueUser = new Users(7, "amazzzing", "123");
        userDao.insert(venueUser);

        Venue newVenue = new Venue("Amazing Bar", "123 A Street, Madison, WI 53704", "Indoor raised stage", "amazingbar@somehwere.com", venueUser);
        int id = dao.insert(newVenue);

        Venue insertedVenue = (Venue)dao.getById(id);
        assertEquals(newVenue, insertedVenue);
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    @Test
    void saveOrUpdateSuccess() {
        Venue preUpdateVenue = (Venue)dao.getById(1);

        preUpdateVenue.setStageType("Small floor area");

        dao.saveOrUpdate(preUpdateVenue);

        Venue updatedVenue = (Venue)dao.getById(1);

        assertNotEquals("Outdoor Patio", updatedVenue.getStageType());

        assertEquals("Small floor area", updatedVenue.getStageType());
    }

    @Test
    void getByPropertyEqualSuccess() {
        ArrayList<Venue> expectedVenue;
        expectedVenue = (ArrayList<Venue>)dao.getByPropertyEqual("name", "Pooleys");
        Venue actualVenue = (Venue)dao.getById(1);

        assertEquals(1, expectedVenue.size());
        assertEquals(expectedVenue.get(0), actualVenue);
    }
}
