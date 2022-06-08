package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.Language;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_delete_language")
public class DeleteLanguageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("language_id");
        Long Long_id = null;

        try {
            Long_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        Language language = DBConnector.getLanguage(Long_id);

        if (language != null) {
            DBConnector.deleteLanguage(language);
        }
        response.sendRedirect("/SprintTask2_admin_panel");
    }
}