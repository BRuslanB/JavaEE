<%--
  Created by IntelliJ IDEA.
  User: rbaid
  Date: 10-May-22
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task1</title>
    <!-- <link href="../css/bootstrap.min.css" rel="stylesheet"> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .bg_color1 {
            background-color: #2F4F4F;
            color: whitesmoke;
        }
        .bg_color2 {
            background-color: #f5f5f5;
            color: black;
        }
        .bg_color3 {
            background-color: #2c3034;
            color: lightgray;
            font-size: smaller;
        }
        .color1 {
            color: gray;
        }
        button:hover {
            background: #2F4F4F;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <!-- Навигационая панель -->
            <nav class="navbar navbar-expand-lg navbar-dark bg_color1">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">NEWS.COM</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">All News</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Culture News</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Sport News</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Cinema News</a>
                            </li>
                        </ul>
                        <form class="d-flex my-auto">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success bg_color1" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
            <!-- Секции -->
            <section class="col-12 bg_color2 my-2">
                <div class="fs-4 fw-bold pt-4 ps-2">
                    The Crazy Way
                </div>
                <div class="fs-5 py-1 color1 py-2 ps-2">
                    Last Friday
                </div>
                <div class="fs-6 py-1 color1 pb-5 ps-2">
                    Author:
                </div>
            </section>
            <!-- Футер -->
            <footer class="col-12 bg_color3 my-1">
                <div class="pt-3 pb-4 fw-bold text-center">
                    Copyright 2021, All Right Reserved
                </div>
            </footer>
        </div>
    </div>
    <!-- <script src="../js/bootstrap.bundle.min.js"></script> -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>