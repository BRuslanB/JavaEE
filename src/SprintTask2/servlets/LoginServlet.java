package SprintTask2.servlets;

import SprintTask2.model.Language;
import SprintTask2.model.News;
import SprintTask2.model.Publication;
import SprintTask2.model.User;
import SprintTask2.db.DBConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/SprintTask2_login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("user_action", "login");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("activ_user");

        if (user != null) {
            request.setAttribute("current_user", user);
        }

        String cookie_lang = null;
        String cookie_public = null;
        Long lang_id = null;
        Long public_id = null;
        Language language = null;
        Publication publication = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("news_lang")) {
                    cookie_lang = cookie.getValue();
                } else if (cookie.getName().equals("news_public")) {
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

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email_value");
        String password = request.getParameter("password_value");

        ArrayList<User> users = DBConnector.getAllUser();

        String redirect = "/SprintTask2_login?userError";

        for (User user : users) {
            if (user != null) {
                if (user.getEmail().equals(email)) {
                    if (user.getPassword().equals(password)) {
                        request.getSession().setAttribute("activ_user", user);
                        redirect = "/SprintTask2_home";
                        break;
                    }
                    redirect = "/SprintTask2_login?passwordError";
                }
            }
        }
        response.sendRedirect(redirect);
    }
}