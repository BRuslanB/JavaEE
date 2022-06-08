package SprintTask2.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/SprintTask2_remove_cookies")
public class RemoveCookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("news_lang")) {
                    cookie.setMaxAge(0); //удаляем куки
                    response.addCookie(cookie);
                } else if ((cookie.getName().equals("news_public"))) {
                    cookie.setMaxAge(0); //удаляем куки
                    response.addCookie(cookie);
                }
            }
        }

        response.sendRedirect("/SprintTask2_home");
    }
}