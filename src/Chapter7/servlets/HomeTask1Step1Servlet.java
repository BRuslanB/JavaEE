package Chapter7.servlets;

import Chapter7.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value = "/chapter7_task1_home")
public class HomeTask1Step1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Student student;
        student = (Student) session.getAttribute("student_data");
        if (student == null) {
            student = new Student();
        }
        request.setAttribute("one_student", student);
        request.getRequestDispatcher("/Chapter7.Task1.Step1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        String name = request.getParameter("name_value");
        String surname = request.getParameter("surname_value");
        int age = Integer.parseInt(request.getParameter("age_value"));
        String city = request.getParameter("city_value");
        String address = request.getParameter("address_value");
        String phone = request.getParameter("phone_value");
        String university = request.getParameter("university_value");
        String faculty = request.getParameter("faculty_value");
        String group = request.getParameter("group_value");

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setAge(age);
        student.setCity(city);
        student.setAddress(address);
        student.setPhone(phone);
        student.setUniversity(university);
        student.setFaculty(faculty);
        student.setGroup(group);

        HttpSession session = request.getSession();
        session.setAttribute("student_data", student);

        response.sendRedirect("/chapter7_task1_step2");
    }
}