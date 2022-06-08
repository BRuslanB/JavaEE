package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.News;
import SprintTask2.model.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/SprintTask2_news_details")
public class NewsDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long news_id = null;
        Long public_id = null;

        try {
            public_id = Long.parseLong(request.getParameter("public"));

        } catch(Exception e) {

        }

        try {
            news_id = Long.parseLong(request.getParameter("news"));

        } catch(Exception e) {

        }

        News news = DBConnector.getNews(news_id);

        if (news != null) {
            request.setAttribute("my_public", public_id);

            ArrayList<Publication> allPublication = DBConnector.getAllPublication("rating", "DESC");
            request.setAttribute("all_publication", allPublication);

            request.setAttribute("one_news", news);
            request.getRequestDispatcher("/SprintTask2.NewsDetails.jsp").forward(request, response);
        } else {
            response.sendRedirect("/SprintTask2_home");
        }
    }
}