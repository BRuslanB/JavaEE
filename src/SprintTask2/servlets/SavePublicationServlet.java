package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_save_publication")
public class SavePublicationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        String id = request.getParameter("publication_id");
        Long Long_id = null;

        try {
            Long_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        String name = request.getParameter("publication_name");
        String description = request.getParameter("publication_description");
        double rating = Double.parseDouble(request.getParameter("publication_rating"));

        Publication publication = DBConnector.getPublication(Long_id);

        if (publication != null) {
            publication.setName(name);
            publication.setDescription(description);
            publication.setRating(rating);

            DBConnector.savePublication(publication);
        }
        response.sendRedirect("/SprintTask2_admin_panel");
    }
}