<%@ page import="Chapter7.model.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task2</title>
    <%@include file="vendor/kz.bitlab.head.jsp"%>
</head>
<body>
    <div class="container">
        <div class="col-6 card-deck row mx-auto">
            <%
                Item[] all_items = (Item[]) request.getAttribute("all_items");
                if (all_items != null) {
                    for (Item item : all_items) {
            %>
                <div class="col-6 mx-auto mt-3">
                    <div class="card">
                        <form action="/chapter7_task2_home" method="post">
                            <div class="card-body text-center">
                                <input type="hidden" name="id_value" value="<%=item.getId()%>">
                                <input type="hidden" name="name_value" value="<%=item.getName()%>">
                                <input type="hidden" name="price_value" value="<%=item.getPrice()%>">
                                <h5 class="card-title"><%=item.getName()%></h5>
                                <p class="card-text"><%=item.getPrice()+"$"%></p>
                                <button class="btn btn-primary">ADD TO CARD</button>
                            </div>
                        </form>
                    </div>
                </div>
            <%
                    }
                }
            %>
        </div>
        <div class="col-6 row mx-auto">
            <div class="col-4 mx-auto mt-3">
                <button type="button" class="btn btn-success ms-2" data-bs-toggle="modal" data-bs-target="#viewModal">
                    VIEW ALL CARD
                </button>
            </div>
        </div>
        <!-- Modal VIEW ALL CARD -->
        <div class="modal fade" id="viewModal" data-bs-backdrop="static" data-bs-keyboard="false"
             tabindex="-1" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">VIEW ALL CARD</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <%
                            ArrayList<Item> choose_items = (ArrayList<Item>) request.getAttribute("choose_items");
                            if (choose_items != null) {
                                int count = 0;
                                for (Item item : choose_items) {
                                    count++;
                        %>
                                <p>
                                    <%=count + ": " + item.getName() + " " + item.getPrice()%>
                                </p>
                        <%
                                }
                            }
                        %>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">OK</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>