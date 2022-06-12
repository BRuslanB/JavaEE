package SprintTask2.servlets;

import SprintTask2.db.DBConnector;
import SprintTask2.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/SprintTask2_admin_panel")
public class AdminPanelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.removeAttribute("user_action");

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

        ArrayList<Publication> allPublication = DBConnector.getAllPublication(null,null);
        request.setAttribute("all_publication", allPublication);

        ArrayList<News> allNews = DBConnector.getAllNews(null, null);
        request.setAttribute("all_news", allNews);

        ArrayList<Comment> allComment = DBConnector.getAllComment();
        request.setAttribute("all_comment", allComment);

        request.getRequestDispatcher("/SprintTask2.AdminPanel.jsp").forward(request, response);
    }
}