package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.Language;
import SprintTask2.model.News;
import SprintTask2.model.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/SprintTask2_home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        String cookie_lang = null;
        String cookie_public = null;
        Long lang_id = null;
        Long public_id = null;
        Language language = null;
        Publication publication = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("news_lang")) {
                    cookie_lang = cookie.getValue();
                } else if ((cookie.getName().equals("news_public"))) {
                    cookie_public = cookie.getValue();
                }
            }
        }

        try {
            lang_id = Long.parseLong(cookie_lang);

        } catch(Exception e) {

        }

        ArrayList<Language> allLanguage = DBConnector.getAllLanguage();
        request.setAttribute("all_language", allLanguage);
/*
        if (lang_id != null && allLanguage.size()>0) {
            language = DBConnector.getLanguage(lang_id);
        } else {
            language = allLanguage.get(0); //выбрать первый имеющийся язык
        }
 */
        if (lang_id != null) language = DBConnector.getLanguage(lang_id);
        request.setAttribute("my_lang", lang_id);

        try {
            public_id = Long.parseLong(cookie_public);

        } catch(Exception e) {

        }

        ArrayList<Publication> allPublication = DBConnector.getAllPublication("rating", "DESC");
        request.setAttribute("all_publication", allPublication);

        if (public_id != null) publication = DBConnector.getPublication(public_id);
        request.setAttribute("my_public", public_id);

        ArrayList<News> allNews = DBConnector.getAllNews(language, publication);
        request.setAttribute("all_news", allNews);

        request.getRequestDispatcher("/SprintTask2.NewsCards.jsp").forward(request, response);
    }
}