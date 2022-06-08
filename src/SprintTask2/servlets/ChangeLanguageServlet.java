package SprintTask2.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_change_language")
public class ChangeLanguageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cookieValue = request.getParameter("lang");

        Cookie cookie = new Cookie("news_lang", cookieValue);
        cookie.setMaxAge(24*3600*30); //задаем время в секундах
        response.addCookie(cookie);

        response.sendRedirect("/SprintTask2_home");
    }
}