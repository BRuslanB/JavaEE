package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.Language;
import SprintTask2.model.News;
import SprintTask2.model.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/SprintTask2_admin_panel")
public class AdminPanelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Language> allLanguage = DBConnector.getAllLanguage();
        request.setAttribute("all_language", allLanguage);

        ArrayList<Publication> allPublication = DBConnector.getAllPublication(null,null);
        request.setAttribute("all_publication", allPublication);

        ArrayList<News> allNews = DBConnector.getAllNews(null, null);
        request.setAttribute("all_news", allNews);

        request.getRequestDispatcher("/SprintTask2.AdminPanel.jsp").forward(request, response);
    }
}