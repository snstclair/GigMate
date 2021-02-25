package gigmate.persistence;

import gigmate.entity.Band;
import gigmate.entity.Venue;
import gigmate.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BandDaoTest {
    GenericDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanBandDb.sql");

        dao = new GenericDao(Band.class);
    }

    @Test
    void getByIdSuccess() {
        Band retrieveBand = (Band)dao.getById(1);
        Band actualBand = new Band(1, "Sky Urchin", "Madison, WI", "Indie Rock", "skyurchin@somewhere.com");
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
        Band newBand = new Band("Moonchild", "Los Angeles, CA", "Jazz", "moonchild@somehwere.com");
        int id = dao.insert(newBand);

        Band insertedBand = (Band)dao.getById(id);
        assertEquals(newBand, insertedBand);
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }
}
