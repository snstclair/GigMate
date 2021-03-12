package gigmate.persistence;

import gigmate.entity.Users;
import gigmate.test.util.Database;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class UsersDaoTest {
    GenericDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDb.sql");

        dao = new GenericDao(Users.class);
    }

    @Test
    void getByIdSuccess() {
        Users retrieveUser = (Users)dao.getById(2);

        Users actualUser = new Users(2, "SinnerAndSaint", "123");
        assertNotNull(retrieveUser);
        assertEquals(actualUser, retrieveUser);
    }
}
