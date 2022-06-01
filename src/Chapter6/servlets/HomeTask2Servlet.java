package Chapter6.servlets;

import Chapter6.model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet(value = "/chapter6_task2_home")
public class HomeTask2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        Client client = new Client();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("client_name")) {
                    client.setName(URLDecoder.decode(cookie.getValue(), "UTF-8"));
                } else if (cookie.getName().equals("client_surname")) {
                    client.setSurname(URLDecoder.decode(cookie.getValue(), "UTF-8"));
                } else if (cookie.getName().equals("client_age")) {
                    client.setAge(Integer.parseInt(URLDecoder.decode(cookie.getValue(), "UTF-8")));
                } else if (cookie.getName().equals("client_country")) {
                    client.setCountry(URLDecoder.decode(cookie.getValue(), "UTF-8"));
                } else if (cookie.getName().equals("client_gender")) {
                    client.setGender(URLDecoder.decode(cookie.getValue(), "UTF-8"));
                } else if (cookie.getName().equals("client_credit_card")) {
                    client.setCredit_card(URLDecoder.decode(cookie.getValue(), "UTF-8"));
                }
            }
        }
        request.setAttribute("my_cookie", client);
        request.getRequestDispatcher("/Chapter6.Task2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        String client_name = request.getParameter("name_value");
        String client_surname = request.getParameter("surname_value");
        String client_age = request.getParameter("age_value");
        String client_country = request.getParameter("country_value");
        String client_gender = request.getParameter("gender_value");
        String client_credit_card = request.getParameter("credit_card_value");

        Cookie cookie;
        cookie = new Cookie("client_name", URLEncoder.encode(client_name, "UTF-8"));
        cookie.setMaxAge(3600*24*30); //задаем время на 1 месяц
        response.addCookie(cookie);

        cookie = new Cookie("client_surname", URLEncoder.encode(client_surname, "UTF-8"));
        cookie.setMaxAge(3600*24*30); //задаем время на 1 месяц
        response.addCookie(cookie);

        cookie = new Cookie("client_age", URLEncoder.encode(client_age, "UTF-8"));
        cookie.setMaxAge(3600*24*30); //задаем время на 1 месяц
        response.addCookie(cookie);

        cookie = new Cookie("client_country", URLEncoder.encode(client_country, "UTF-8"));
        cookie.setMaxAge(3600*24*30); //задаем время на 1 месяц
        response.addCookie(cookie);

        cookie = new Cookie("client_gender", URLEncoder.encode(client_gender, "UTF-8"));
        cookie.setMaxAge(3600*24*30); //задаем время на 1 месяц
        response.addCookie(cookie);

        cookie = new Cookie("client_credit_card", URLEncoder.encode(client_credit_card, "UTF-8"));
        cookie.setMaxAge(3600*24*30); //задаем время на 1 месяц
        response.addCookie(cookie);

        response.sendRedirect("/chapter6_task2_home");
    }
}