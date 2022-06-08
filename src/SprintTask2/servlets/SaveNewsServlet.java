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

@WebServlet(value = "/SprintTask2_save_news")
public class SaveNewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        String id = request.getParameter("news_id");
        Long Long_id = null;

        try {
            Long_id = Long.parseLong(id);

        } catch(Exception e) {

        }

        String title = request.getParameter("news_title");
        String short_content = request.getParameter("news_short_content");
        String content = request.getParameter("news_content");
        Long language_id = Long.parseLong(request.getParameter("news_language_id"));
        Long publication_id = Long.parseLong(request.getParameter("news_publication_id"));
        String picture_url = request.getParameter("news_picture_url");

        News news = DBConnector.getNews(Long_id);

        if (news != null) {

            Language language = DBConnector.getLanguage(language_id);
            Publication publication = DBConnector.getPublication(publication_id);

            if (language != null && publication != null) {
                news.setTitle(title);
                news.setShort_content(short_content);
                news.setContent(content);
                news.setLanguage(language);
                news.setPublication(publication);
                news.setPicture_url(picture_url);

                DBConnector.saveNews(news);
            }
        }
        response.sendRedirect("/SprintTask2_admin_panel");
    }
}