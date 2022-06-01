<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task3</title>
    <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
    <div class="container">
        <%
            String cookieValue = (String) request.getAttribute("my_cookie");
            Map<Integer, String> inter_face = (Map) request.getAttribute("interface");
            Map<String, String> content = (Map) request.getAttribute("content");
            if (inter_face != null && content != null && cookieValue != null) {
        %>
            <div class="row">
                <div class="col-8 ms-auto mt-4">
                    <form action="/chapter6_task3_home" method="post">
                        <div class="d-flex justify-content-between">
                            <label for="language_value" class="form-label col-3"><%=inter_face.get(1)%></label>
                            <select id="language_value" name="language_value" class="form-select">
                                <option value="English" <%=cookieValue.equals("English") ? "selected" : ""%>>
                                    English</option>
                                <option value="Русский" <%=cookieValue.equals("Русский") ? "selected" : ""%>>
                                    Русский</option>
                            </select>
                            <div class="col-3 ms-3">
                                <button class="btn btn-light"><%=inter_face.get(2)%></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-10 mx-auto mt-6">
                    <!-- <form> -->
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="name_value" class="form-label col-3"><%=inter_face.get(3)%></label>
                            <input id="name_value" name="name_value" type="text"
                                   class="form-control" value="<%=content.get("name")%>">
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="age_value" class="form-label col-3"><%=inter_face.get(4)%></label>
                            <input id="age_value" name="age_value" type="number" min="0" max="100"
                                   class="form-control" value="<%=content.get("age")%>">
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="country_value" class="form-label col-3"><%=inter_face.get(5)%></label>
                            <select id="country_value" name="country_value" class="form-select">
                                <option value="<%=cookieValue.equals("English") ? "ARMENIA" : "АРМЕНИЯ"%>"
                                        <%=(content.get("country")=="ARMENIA" ||
                                        content.get("country")=="АРМЕНИЯ") ? "selected" : ""%>>
                                        <%=cookieValue.equals("English") ? "ARMENIA" : "АРМЕНИЯ"%></option>
                                <option value="<%=cookieValue.equals("English") ? "BELARUS" : "БЕЛОРУСЬ"%>"
                                        <%=(content.get("country")=="BELARUS" ||
                                        content.get("country")=="БЕЛОРУСЬ") ? "selected" : ""%>>
                                        <%=cookieValue.equals("English") ? "BELARUS" : "БЕЛОРУСЬ"%></option>
                                <option value="<%=cookieValue.equals("English") ? "GEORGIA" : "ГРУЗИЯ"%>"
                                        <%=(content.get("country")=="GEORGIA" ||
                                        content.get("country")=="ГРУЗИЯ") ? "selected" : ""%>>
                                        <%=cookieValue.equals("English") ? "GEORGIA" : "ГРУЗИЯ"%></option>
                                <option value="<%=cookieValue.equals("English") ? "KAZAKHSTAN" : "КАЗАХСТАН"%>"
                                        <%=(content.get("country")=="KAZAKHSTAN" ||
                                        content.get("country")=="КАЗАХСТАН") ? "selected" : ""%>>
                                        <%=cookieValue.equals("English") ? "KAZAKHSTAN" : "КАЗАХСТАН"%></option>
                                <option value="<%=cookieValue.equals("English") ? "UZBEKISTAN" : "УЗБЕКИСТАН"%>"
                                        <%=(content.get("country")=="UZBEKISTAN" ||
                                        content.get("country")=="УЗБЕКИСТАН") ? "selected" : ""%>>
                                        <%=cookieValue.equals("English") ? "UZBEKISTAN" : "УЗБЕКИСТАН"%></option>
                            </select>
                        </div>
                        <div class="mt-3 d-flex justify-content-start">
                            <label class="form-label col-3"><%=inter_face.get(6)%></label>
                            <div class="form-check form-check-inline">
                                <input type="radio" name="gender_value" id="gender_value1" value="Male"
                                       class="form-check-input" <%=(content.get("gender") == "Male" ||
                                        content.get("gender") == "Мужской") ? "checked" : ""%>>
                                <label class="form-check-label" for="gender_value1"><%=inter_face.get(7)%></label>
                            </div>
                            <div class="form-check form-check-inline ms-2">
                                <input type="radio" name="gender_value" id="gender_value2" value="Female"
                                       class="form-check-input" <%=(content.get("gender") == "Female" ||
                                       content.get("gender") == "Женский") ? "checked" : ""%>>
                                <label class="form-check-label" for="gender_value2"><%=inter_face.get(8)%></label>
                            </div>
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="credit_card_value" class="form-label col-3"><%=inter_face.get(9)%></label>
                            <input id="credit_card_value" name="credit_card_value" type="text"
                                   class="form-control" value="<%=content.get("number")%>">
                        </div>
                        <div class="mt-4 col-3">
                            <button class="btn btn-secondary px-3"><%=inter_face.get(10)%></button>
                        </div>
                    <!-- </form> -->
                </div>
            </div>
        <%
            }
        %>
    </div>
</body>
</html>