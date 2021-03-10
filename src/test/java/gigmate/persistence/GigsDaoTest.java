package gigmate.persistence;

import gigmate.entity.Band;
import gigmate.entity.Gigs;
import gigmate.entity.Users;
import gigmate.entity.Venue;
import gigmate.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GigsDaoTest {
    GenericDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDb.sql");

        dao = new GenericDao(Gigs.class);

    }

    @Test
    void getByIdSuccess() {
        GenericDao userDao = new GenericDao(Users.class);
        Users bandUser = (Users)userDao.getById(1);
        Users venueUser = (Users)userDao.getById(4);

        Gigs retrieveGig = (Gigs)dao.getById(2);
        Band band = new Band(1, "Sky Urchin", "Madison, WI", "Indie Rock", "skyurchin@somewhere.com", bandUser);
        Venue venue = new Venue(1, "Pooleys", "5441 High Crossing Blvd, Madison, WI 53718", "Outdoor Patio", "pooleys@somewhere.com", venueUser);


        Gigs actualGig = new Gigs(2, band, venue, LocalDate.parse("2021-06-17"), LocalTime.parse("08:30"));
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

        Gigs newGig = new Gigs(band, venue, LocalDate.parse("2021-08-18"), LocalTime.parse("08:00"));

        int id = dao.insert(newGig);

        Gigs insertedGig = (Gigs)dao.getById(id);
        assertEquals(newGig, insertedGig);
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    @Test
    void saveOrUpdateSuccess() {
        Gigs preUpdateGig = (Gigs)dao.getById(1);

        preUpdateGig.setDate(LocalDate.parse("2021-05-15"));

        dao.saveOrUpdate(preUpdateGig);

        Gigs updatedGig = (Gigs)dao.getById(1);

        assertNotEquals(LocalDate.parse("2021-05-13"), updatedGig.getDate());

        assertEquals(LocalDate.parse("2021-05-15"), updatedGig.getDate());

    }

    @Test
    void getByPropertyEqualSuccess() {
        ArrayList<Gigs> expectedGigs;
        expectedGigs= (ArrayList<Gigs>)dao.getByPropertyEqual("id", "2");
        Gigs actualGig = (Gigs)dao.getById(2);

        assertEquals(1, expectedGigs.size());
        assertEquals(expectedGigs.get(0), actualGig);
    }
}
