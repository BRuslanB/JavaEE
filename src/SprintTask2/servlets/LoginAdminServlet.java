package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.out;

@WebServlet(value = "/SprintTask2_login_admin")
public class LoginAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("user_action", "login");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("activ_user");

        if (user != null) {
            request.setAttribute("current_user", user);
        }

        ArrayList<Role> allRole = DBConnector.getAllRole();
        request.setAttribute("all_role", allRole);

        ArrayList<User> allUser = DBConnector.getAllUser();
        request.setAttribute("all_user", allUser);

        ArrayList<Language> allLanguage = DBConnector.getAllLanguage();
        request.setAttribute("all_language", allLanguage);

        ArrayList<Publication> allPublication = DBConnector.getAllPublication(null, null);
        request.setAttribute("all_publication", allPublication);

        ArrayList<News> allNews = DBConnector.getAllNews(null, null);
        request.setAttribute("all_news", allNews);

        request.getRequestDispatcher("/SprintTask2.AdminPanel.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email_value");
        String password = request.getParameter("password_value");

        ArrayList<User> users = DBConnector.getAllUser();

        String redirect = "/SprintTask2_login_admin?userError";

        for (User user : users) {
            if (user != null) {
                if (user.getEmail().equals(email)) {
                    if (user.getPassword().equals(password)) {
                        if (user.getRole().getName().equals("admin")) {
                            out.print(user.getEmail());
                            request.getSession().setAttribute("activ_user", user);
                            redirect = "/SprintTask2_admin_panel";
                            break;
                        } else {
                            redirect = "/SprintTask2_login_admin?accessError";
                        }
                    } else {
                        redirect = "/SprintTask2_login_admin?passwordError";
                    }
                }
            }
        }
        response.sendRedirect(redirect);
    }
}