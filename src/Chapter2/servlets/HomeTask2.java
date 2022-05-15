package Chapter2.servlets;

import Chapter2.db.DBManager;
import Chapter2.model.Tasks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/Chapter2.HomeTask2")
public class HomeTask2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Tasks> tasks = DBManager.getAllTasks();
        request.setCharacterEncoding("utf8");
        request.setAttribute("zadachi",tasks);
        request.getRequestDispatcher("/Chapter2.Task2.AllTasks.jsp").forward(request, response);
    }
}