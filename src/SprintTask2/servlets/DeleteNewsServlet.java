package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_delete_news")
public class DeleteNewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("news_id");
        Long Long_id = null;

        try {
            Long_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        News news = DBConnector.getNews(Long_id);

        if (news != null) {
            DBConnector.deleteNews(news);
        }
        response.sendRedirect("/SprintTask2_admin_panel");
    }
}