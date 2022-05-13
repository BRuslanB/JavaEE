package Chapter2.servlets;

import Chapter2.db.DBManager;
import Chapter2.model.Tasks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/details")
public class Details extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        String id = request.getParameter("id");
        Long taskId = null;
        try {
            taskId = Long.parseLong(id);
        }catch (Exception e){
        }
        Tasks task = DBManager.getTask(taskId);
        if(task != null){
            request.setAttribute("zadacha", task);
            request.getRequestDispatcher("/Chapter2.Task2.Details.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/Chapter2.Task2.NotFound.jsp").forward(request, response);
        }
    }
}