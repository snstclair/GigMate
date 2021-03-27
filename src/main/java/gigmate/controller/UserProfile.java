package gigmate.controller;

import gigmate.entity.*;
import gigmate.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(
        urlPatterns = {"/userProfile"}
)
public class UserProfile extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao bandDao = new GenericDao(Band.class);
        GenericDao venueDao = new GenericDao(Venue.class);

        request.setAttribute("bands", bandDao.getAll());
        request.setAttribute("venues", venueDao.getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(request, response);
    }
}
