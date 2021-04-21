<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Radek
  Date: 20.04.2021
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bulma@0.9.2/css/bulma.min.css"
    />
    <link rel="stylesheet" href="./style/style.css" />
    <title>Ski Jumping Analyzer</title>
</head>
<body>
<nav class="navbar is-fixed-top">
    <div class="container">
        <div class="navbar-brand">
            <img src="./logo/logo.png" class="logo" />
        </div>

        <div id="navMenu" class="navbar-menu">
            <div class="navbar-start">
                <a class="navbar-item" href="/homepage">Strona główna</a>
                <a class="navbar-item">JavaDoc</a>
                <a class="navbar-item">Autorzy</a>
            </div>

            <div class="navbar-end">
                <div class="navbar-item">
                    <div class="buttons">
                        <a class="button is-info" href="TournamentChooser.html">
                            <strong>Rozpocznij analizę</strong>
                        </a>
                        <a class="button is-light" href="HistorySearch.html"
                        >Historia analiz</a
                        >
                    </div>
                </div>
            </div>
        </div>
    </div>
</nav>
<!-- -------------------------------------------------------------------------------------------------------- -->
<form action="/jumper_result" method="post">
<section class="table list">
    <div class="container">
        <div class="table-container">
            <div class="control-panel container is-flex is-justify-content-space-between is-align-items-center">
                <p class="title is-3" style="margin: 0">
                    Wybierz konkursy do analizy:
                </p>
                <div class="is-flex is-justify-content-flex-start is-align-items-center">
                    <p class="title is-4" style="margin: 0">Analizuj według:</p>
                    <input type="text" name="pole">
                    <button  type="submit" class="button is-primary is-link" style="margin-left: 10px">
                        Skoczek
                    </button>
                    <a class="button is-link" style="margin-left: 10px">Kraj</a>
                </div>
            </div>
            <table class="table is-striped is-hoverable is-fullwidth">
                <thead>
                <tr>
                    <th>Dodaj do analizy:</th>
                    <th title="date">Data</th>
                    <th title="place">Miejsce</th>
                    <th title="gender">Płeć</th>
                </tr>
                </thead>
                <tbody>
<%--                <c:forEach items="${tournaments}" var="tournament">--%>
<%--                <tr>--%>
<%--                    <th>${tournament.date}</th>--%>
<%--                    <th>${tournament.place}</th>--%>
<%--                    <th>${tournament.gender}</th>--%>
<%--                </tr>--%>
<%--                </c:forEach>--%>
                </tbody>
            </table>

        </div>
    </div>
</section>
</form>
</body>
</html>