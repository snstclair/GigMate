package gigmate.controller;

import gigmate.entity.*;
import gigmate.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(
        name = "Home",
        urlPatterns = {"/home"}
)
public class Home extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao bandDao = new GenericDao(Band.class);
        GenericDao venueDao = new GenericDao(Venue.class);
        List<Band> bands = bandDao.getAll();
        List<Venue> venues = venueDao.getAll();

        logger.debug("Checking bands list" + bands);
        logger.debug("Checking venues list" + venues);

        request.setAttribute("bands", bands);
        request.setAttribute("venues", venues);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/homePage.jsp");
        dispatcher.forward(request, response);
    }
}
