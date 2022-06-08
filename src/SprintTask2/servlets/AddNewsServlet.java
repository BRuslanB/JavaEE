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

@WebServlet(value = "/SprintTask2_add_news")
public class AddNewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        String title = request.getParameter("news_title");
        String short_content = request.getParameter("news_short_content");
        String content = request.getParameter("news_content");
        Long language_id = Long.parseLong(request.getParameter("news_language_id"));
        Long publication_id = Long.parseLong(request.getParameter("news_publication_id"));
        String picture_url = request.getParameter("news_picture_url");

        Language language = new Language();
        language.setId(language_id);

        Publication publication = new Publication();
        publication.setId(publication_id);

        News news = new News();
        news.setTitle(title);
        news.setShort_content(short_content);
        news.setContent(content);
        news.setLanguage(language);
        news.setPublication(publication);
        news.setPicture_url(picture_url);

        DBConnector.addNews(news);

        response.sendRedirect("/SprintTask2_admin_panel");
    }
}