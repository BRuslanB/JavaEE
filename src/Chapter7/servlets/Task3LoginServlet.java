package Chapter7.servlets;

import Chapter7.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/chapter7_task3_login")
public class Task3LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/Chapter7.Task3.Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login_value");
        String password = request.getParameter("password_value");

        User[] users = new User[4];
        users[0] = new User(1L, "test", "test", "Тестовый пользователь");
        users[1] = new User(2L, "admin", "admin", "Администратор");
        users[2] = new User(3L, "user", "user", "Продвинутый пользователь");

        String redirect = "/chapter7_task3_login?user_error";

        for (User user : users) {
            if (user != null) {
                if (user.getLogin().equals(login)) {
                    if (user.getPassword().equals(password)) {
                        request.getSession().setAttribute("activ_user", user);
                        redirect = "/chapter7_task3_profile";
                        break;
                    }
                    redirect = "/chapter7_task3_login?password_error";
                }
            }
        }
        response.sendRedirect(redirect);
    }
}