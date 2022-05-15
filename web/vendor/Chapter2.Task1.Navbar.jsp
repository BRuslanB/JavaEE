<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-dark bg_color1">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">NEWS.COM</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="/Chapter2.Task1.AllNews.jsp">All News</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/Chapter2.Task1.CultureNews.jsp">Culture News</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/Chapter2.Task1.SportNews.jsp">Sport News</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/Chapter2.Task1.CinemaNews.jsp">Cinema News</a>
                        </li>
                    </ul>
                    <form class="d-flex my-auto">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-light" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
</div>