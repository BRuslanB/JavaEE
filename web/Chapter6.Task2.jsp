<%@ page import="Chapter6.model.Client" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task2</title>
    <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-10 mx-auto mt-4">
                <%
                    Client client = (Client) request.getAttribute("my_cookie");
                    if (client != null) {
                %>
                    <form action="/chapter6_task2_home" method="post">
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="name_value" class="form-label col-2">Name:</label>
                            <input id="name_value" name="name_value" type="text"
                                   class="form-control" value="<%=client.getName()%>">
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="surname_value" class="form-label col-2">Surname:</label>
                            <input id="surname_value" name="surname_value" type="text"
                                class="form-control" value="<%=client.getSurname()%>">
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="age_value" class="form-label col-2">Age:</label>
                            <input id="age_value" name="age_value" type="number" min="0" max="100"
                                class="form-control" value="<%=client.getAge()%>">
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="country_value" class="form-label col-2">Country:</label>
                            <select id="country_value" name="country_value" class="form-select">
                                <option value="" <%=client.getCountry()=="" ? "selected" : ""%>></option>
                                <option value="ARMENIA" <%=client.getCountry()=="ARMENIA" ? "selected" : ""%>>
                                    ARMENIA</option>
                                <option value="BELARUS" <%=client.getCountry()=="BELARUS" ? "selected" : ""%>>
                                    BELARUS</option>
                                <option value="GEORGIA" <%=client.getCountry()=="GEORGIA" ? "selected" : ""%>>
                                    GEORGIA</option>
                                <option value="KAZAKHSTAN" <%=client.getCountry()=="KAZAKHSTAN" ? "selected" : ""%>>
                                    KAZAKHSTAN</option>
                                <option value="UZBEKISTAN" <%=client.getCountry()=="UZBEKISTAN" ? "selected" : ""%>>
                                    UZBEKISTAN</option>
                            </select>
                        </div>
                        <div class="mt-3 d-flex justify-content-start">
                            <label class="form-label col-2">Gender:</label>
                            <div class="form-check form-check-inline">
                                <input type="radio" name="gender_value" id="gender_value1" value="male"
                                    class="form-check-input" <%=client.getGender().equals("male") ? "checked" : ""%>>
                                <label class="form-check-label" for="gender_value1">Male</label>
                            </div>
                            <div class="form-check form-check-inline ms-2">
                                <input type="radio" name="gender_value" id="gender_value2" value="female"
                                    class="form-check-input" <%=client.getGender().equals("female") ? "checked" : ""%>>
                                <label class="form-check-label" for="gender_value2">Female</label>
                            </div>
                        </div>
                        <div class="mt-3 d-flex justify-content-between">
                            <label for="credit_card_value" class="form-label col-2">Credit Card:</label>
                            <input id="credit_card_value" name="credit_card_value" type="text"
                                class="form-control" value="<%=client.getCredit_card()%>">
                        </div>
                        <div class="mt-3 col-3">
                            <button class="btn btn-secondary px-3">SAVE</button>
                        </div>
                    </form>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</body>
</html>