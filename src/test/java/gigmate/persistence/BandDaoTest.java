package gigmate.persistence;

import gigmate.entity.Band;
import gigmate.entity.Users;
import gigmate.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BandDaoTest {
    GenericDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDb.sql");

        dao = new GenericDao(Band.class);
    }

    @Test
    void getByIdSuccess() {
        Band retrieveBand = (Band)dao.getById(1);
        GenericDao userDao = new GenericDao(Users.class);
        Users bandUser = (Users)userDao.getById(1);

        Band actualBand = new Band(1, "Sky Urchin", "Madison, WI", "Indie Rock", "skyurchin@somewhere.com", bandUser);
        assertNotNull(retrieveBand);
        assertEquals(actualBand, retrieveBand);

    }

    @Test
    void getAllSuccess() {
        List<Band> bands = dao.getAll();

        assertEquals(3, bands.size());
    }

    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(Users.class);
        Users newUser = new Users(7, "childofmoon", "123");

        Band newBand = new Band("Moonchild", "Los Angeles, CA", "Jazz", "moonchild@somehwere.com", newUser);
        int id = dao.insert(newBand);

        Band insertedBand = (Band)dao.getById(id);
        assertEquals(newBand, insertedBand);
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    @Test
    void saveOrUpdateSuccess() {
        Band preUpdateBand = (Band)dao.getById(1);

        preUpdateBand.setLocation("Milwaukee, WI");

        dao.saveOrUpdate(preUpdateBand);

        Band updatedBand = (Band)dao.getById(1);

        assertNotEquals("Madison, WI", updatedBand.getLocation());

        assertEquals("Milwaukee, WI", updatedBand.getLocation());

    }

    @Test
    void getByPropertyEqualSuccess() {
        ArrayList<Band> expectedBand;
        expectedBand= (ArrayList<Band>)dao.getByPropertyEqual("genera", "Punk");
        Band actualBand = (Band)dao.getById(2);

        assertEquals(1, expectedBand.size());
        assertEquals(expectedBand.get(0), actualBand);
    }
}
