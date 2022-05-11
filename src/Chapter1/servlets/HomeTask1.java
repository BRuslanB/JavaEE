package Chapter1.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/Chapter1.HomeTask1")
public class HomeTask1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html lang=\"en\">");
            out.print("<head>");
                out.print("<meta charset=\"UTF-8\">");
                out.print("<title>Task1</title>");
                //out.print("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
                out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">");
                out.print("<style>");
                    out.print(".button_style {");
                        out.print("border-style: none;");
                        out.print("border-radius: 0;");
                        out.print("background-color: #00008B;");
                        out.print("color: white;");
                        out.print("padding: 5px 15px;");
                        out.print("margin-left: auto;");
                        out.print("display: block");
                    out.print("}");
                out.print("</style>");
            out.print("</head>");
            out.print("<body>");
                out.print("<div class=\"container\">");
                    out.print("<div class=\"row\">");
                        out.print("<div class=\"col-6\">");
                            out.print("<div class=\"my-4 d-flex justify-content-between\">");
                                out.print("<label for=\"nameField\" class=\"form-label col-3\">NAME:</label>");
                                out.print("<input id=\"nameField\" type=\"text\" class=\"form-control\" placeholder=\"Insert name\">");
                            out.print("</div>");
                            out.print("<div class=\"mb-4 d-flex justify-content-between\">");
                                out.print("<label for=\"surnameField\" class=\"form-label col-3\">SURNAME:</label>");
                                out.print("<input id=\"surnameField\" type=\"text\" class=\"form-control\" placeholder=\"Insert surname\">");
                            out.print("</div>");
                            out.print("<div class=\"mb-4 d-flex justify-content-between\">");
                                out.print("<label for=\"foodField\" class=\"form-label col-3\">FOOD:</label>");
                                out.print("<select id=\"foodField\" class=\"form-control\">");
                                    out.print("<option value=\"Burger\">Burger - 2000 KZT</option>");
                                    out.print("<option value=\"CheeseBurger\">CheeseBurger - 2500 KZT</option>");
                                    out.print("<option value=\"HotDog\">HotDog - 1500 KZT</option>");
                                out.print("</select>");
                            out.print("</div>");
                            out.print("<div class=\"d-flex justify-content-between\">");
                                out.print("<div class=\"col-3\"></div>");
                                out.print("<div>");
                                    out.print("<button class=\"button_style\" onclick=\"orderFood()\">ORDER FOOD</button>");
                                out.print("</div>");
                            out.print("</div>");
                        out.print("</div>");
                    out.print("</div>");
                out.print("</div>");
                //out.print("<script src=\"js/bootstrap.bundle.min.js\"></script>");
                out.print("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>");
            out.print("</body>");
            out.print("<script>");
                out.print("function orderFood() {");
                    out.print("let s = nameField.value + \" \" + surnameField.value + \" ordered \" + foodField.value;");
                    out.print("alert(s);");
                    out.print("}");
            out.print("</script>");
        out.print("</html>");
    }
}