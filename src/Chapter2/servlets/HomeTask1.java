package Chapter2.servlets;

import Chapter2.db.DBManager;
import Chapter2.model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/Chapter2.HomeTask1")
public class HomeTask1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        //ArrayList<News> news = DBManager.getAllNews();
        //request.setAttribute("novosti",news);
        request.getRequestDispatcher("Chapter2.Task1.AllNews.jsp").forward(request, response);
    }
}