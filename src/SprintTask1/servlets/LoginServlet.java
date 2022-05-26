package SprintTask1.servlets;

import SprintTask1.db.DBConnector;
import SprintTask1.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/SprintTask1_login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/SprintTask1.SignIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("user_email");
        String password = request.getParameter("user_password");

        ArrayList<User> users = DBConnector.getAllUser();
        if (users != null) {
            for (User user : users) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                    //out.print("YES" + "\n");
                    request.setAttribute("one_user", user);
                    request.getRequestDispatcher("/SprintTask1.UserProfile.jsp").forward(request, response);
                }
            }
        }
        //out.print("NO" + "\n");
        response.sendRedirect("/SprintTask1_login?error");
    }
}