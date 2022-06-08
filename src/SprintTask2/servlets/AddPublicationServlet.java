package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_add_publication")
public class AddPublicationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        String name = request.getParameter("publication_name");
        String description = request.getParameter("publication_description");
        double rating = Double.parseDouble(request.getParameter("publication_rating"));

        Publication publication = new Publication();
        publication.setName(name);
        publication.setDescription(description);
        publication.setRating(rating);

        DBConnector.addPublication(publication);

        response.sendRedirect("/SprintTask2_admin_panel");
    }
}