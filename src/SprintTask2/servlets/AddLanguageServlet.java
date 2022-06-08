package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.Language;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_add_language")
public class AddLanguageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        String name = request.getParameter("language_name");
        String code = request.getParameter("language_code");

        Language language = new Language();
        language.setName(name);
        language.setCode(code);

        DBConnector.addLanguage(language);

        response.sendRedirect("/SprintTask2_admin_panel");
    }
}