package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.Language;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_save_language")
public class SaveLanguageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        String id = request.getParameter("language_id");
        Long Long_id = null;

        try {
            Long_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        String name = request.getParameter("language_name");
        String code = request.getParameter("language_code");

        Language language = DBConnector.getLanguage(Long_id);

        if (language != null) {
            language.setName(name);
            language.setCode(code);

            DBConnector.saveLanguage(language);
        }
        response.sendRedirect("/SprintTask2_admin_panel");
    }
}