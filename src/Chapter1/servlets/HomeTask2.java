package Chapter1.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/Chapter1.HomeTask2")
public class HomeTask2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html lang=\"en\">");
            out.print("<head>");
                out.print("<meta charset=\"UTF-8\">");
                out.print("<title>Task 2</title>");
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
                                out.print("<label for=\"full_nameField\" class=\"form-label col-3\">FULL NAME: </label>");
                                out.print("<input id=\"full_nameField\" type=\"text\" class=\"form-control\" placeholder=\"Insert full name\">");
                            out.print("</div>");
                            out.print("<div class=\"mb-4 d-flex justify-content-between\">");
                                out.print("<label for=\"ageField\" class=\"form-label col-3\">AGE: </label>");
                                out.print("<input id=\"ageField\" type=\"number\" class=\"form-control\" min=\"0\" max=\"100\" value=\"1\" placeholder=\"Insert age\">");
                            out.print("</div>");
                            out.print("<div class=\"mb-2 d-flex\">");
                                out.print("<label for=\"genderField\" class=\"form-label col-3\">GENDER: </label>");
                                out.print("<div class=\"form-check\">");
                                    out.print("<input class=\"form-check-input\" type=\"radio\" name=\"genderField\" id=\"genderField1\" value=\"male\" checked>");
                                    out.print("<label class=\"form-check-label\" for=\"genderField1\">Male</label>");
                                out.print("</div>");
                                out.print("<div class=\"form-check mx-3\">");
                                    out.print("<input class=\"form-check-input\" type=\"radio\" name=\"genderField\" id=\"genderField2\" value=\"female\">");
                                    out.print("<label class=\"form-check-label\" for=\"genderField2\">Female</label>");
                                out.print("</div>");
                            out.print("</div>");
                            out.print("<div class=\"d-flex justify-content-between\">");
                                out.print("<div class=\"col-3\"></div>");
                                out.print("<div>");
                                    out.print("<button class=\"button_style\" onclick=\"submit()\">SUBMIT</button>");
                                out.print("</div>");
                            out.print("</div>");
                        out.print("</div>");
                    out.print("</div>");
                out.print("</div>");
                //out.print("<script src=\"js/bootstrap.bundle.min.js\"></script>");
                out.print("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>");
            out.print("</body>");
            out.print("<script>");
                out.print("function submit() {");
                    out.print("let s = \"Hello \";");
                    out.print("if (genderField1.checked) {");
                        out.print("if (parseInt(ageField.value) >= 18) ");
                            out.print("s = s + \"Dear Mister \" + full_nameField.value + \"!\";");
                        out.print(" else ");
                            out.print("s = s + \"Dude Mister \" + full_nameField.value + \"!\";");
                    out.print("} else {");
                        out.print("if (parseInt(ageField.value) >= 18) ");
                            out.print("s = s + \"Dear Miss \" + full_nameField.value + \"!\";");
                        out.print(" else ");
                            out.print("s = s + \"Dude Miss \" + full_nameField.value + \"!\";");
                    out.print("}");
                    out.print("alert(s);");
                out.print("}");
            out.print("</script>");
        out.print("</html>");
    }
}