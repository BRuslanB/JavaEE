package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/SprintTask2_register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("user_action", "register");

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
        String full_name = request.getParameter("full_name_value");
        String re_password = request.getParameter("re_password_value");

        String redirect = "/SprintTask2_register?userError";

        User user = DBConnector.getUser(email);
        if (user == null) {

            redirect = "/SprintTask2_register?passwordError";

            if (password.equals(re_password)) {

                Role user_role = new Role();
                ArrayList<Role> roles = DBConnector.getAllRole();

                if (roles != null) {
                    for (Role role : roles) {
                        if (role.getName().equals("user")) {
                            user_role.setId(role.getId());
                            break;
                        }
                    }
                }

                User new_user = new User();
                new_user.setEmail(email);
                new_user.setPassword(password);
                new_user.setFull_name(full_name);
                new_user.setRole(user_role);

                DBConnector.addUser(new_user);
                redirect = "/SprintTask2_register?success";

            } else {
                redirect = "/SprintTask2_register?retypeError";
            }
        }
        response.sendRedirect(redirect);
    }
}