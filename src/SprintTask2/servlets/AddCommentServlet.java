package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_add_comment")
public class AddCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        String comm = request.getParameter("comment_value");
        Long user_id = Long.parseLong(request.getParameter("user_id"));

        Long news_id = null;
        Long public_id = null;

        try {
            news_id = Long.parseLong(request.getParameter("news_id"));

        } catch(Exception e) {

        }

        try {
            public_id = Long.parseLong(request.getParameter("public_id"));

        } catch(Exception e) {

        }

        User user = new User();
        user.setId(user_id);

        News news = new News();
        news.setId(news_id);

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setNews(news);
        comment.setComment(comm);

        if (DBConnector.addComment(comment)) {
            response.sendRedirect("/SprintTask2_news_details?news="+news_id+"&public="+public_id);
        } else {
            response.sendRedirect("/SprintTask2_home");
        }
    }
}