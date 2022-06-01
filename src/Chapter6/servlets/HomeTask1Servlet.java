package Chapter6.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet(value = "/chapter6_task1_home")
public class HomeTask1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        String cookieValue = "Default Site Name";

        if (cookies != null) {
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("site_name")){
                    //cookieValue = cookie.getValue();
                    cookieValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    break;
                }
            }
        }
        request.setAttribute("my_cookie", cookieValue);
        request.getRequestDispatcher("/Chapter6.Task1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        String cookieValue = request.getParameter("cookie_value");

        //Cookie cookie = new Cookie("site_name", cookieValue);
        Cookie cookie = new Cookie("site_name", URLEncoder.encode(cookieValue, "UTF-8"));
        response.addCookie(cookie);
        response.sendRedirect("/chapter6_task1_home");
    }
}