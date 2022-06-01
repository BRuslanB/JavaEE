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
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/chapter6_task3_home")
public class HomeTask3Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        String cookieValue = "English";

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("language")) {
                    cookieValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    break;
                }
            }
        }

        Map<Integer, String> interface_ru = new HashMap<Integer, String>();
        interface_ru.put(1, "Выберите язык:");
        interface_ru.put(2, "Выбрать");
        interface_ru.put(3, "Наименование:");
        interface_ru.put(4, "Возраст:");
        interface_ru.put(5, "Страна:");
        interface_ru.put(6, "Пол:");
        interface_ru.put(7, "Мужской");
        interface_ru.put(8, "Женский");
        interface_ru.put(9, "Номер страховки:");
        interface_ru.put(10, "Отправить документ");

        Map<String, String> content_ru = new HashMap<String, String>();
        content_ru.put("name", "Документ страховки");
        content_ru.put("age", "21");
        content_ru.put("country", "КАЗАХСТАН");
        content_ru.put("gender", "Мужской");
        content_ru.put("number", "545 344 234 124");

        Map<Integer, String> interface_en = new HashMap<Integer, String>();
        interface_en.put(1, "Choose language:");
        interface_en.put(2, "Choose");
        interface_en.put(3, "Name:");
        interface_en.put(4, "Age:");
        interface_en.put(5, "Country:");
        interface_en.put(6, "Gender:");
        interface_en.put(7, "Male");
        interface_en.put(8, "Female");
        interface_en.put(9, "Number Insurance:");
        interface_en.put(10, "Send Document");

        Map<String, String> content_en = new HashMap<String, String>();
        content_en.put("name", "Document Social Insurance");
        content_en.put("age", "21");
        content_en.put("country", "KAZAKHSTAN");
        content_en.put("gender", "Male");
        content_en.put("number", "545 344 234 124");

        if (cookieValue.equals("English")) {
            request.setAttribute("interface", interface_en);
            request.setAttribute("content", content_en);
        } else {
            request.setAttribute("interface", interface_ru);
            request.setAttribute("content", content_ru);
        }
        request.setAttribute("my_cookie", cookieValue);
        request.getRequestDispatcher("Chapter6.Task3.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        String cookieValue = request.getParameter("language_value");

        Cookie cookie = new Cookie("language", URLEncoder.encode(cookieValue, "UTF-8"));
        response.addCookie(cookie);
        response.sendRedirect("/chapter6_task3_home");
    }
}