<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.2/css/bulma.min.css"/>
    <link rel="stylesheet" href="./style/style.css" />
    <title>Ski Jumping Analyzer</title>
</head>
<body>

<nav class="navbar" style="padding: 20px 0">
    <jsp:include page="navbar.jsp"/>
</nav>

<section class="hero is-info">
    <div class="hero-body">
        <div class="container">
            <h1 class="title">
                Wyniki skoczków z wybranych konkursów
            </h1>
        </div>
    </div>
</section>
<section class="section">
    <div class="container">
        <c:choose>
        <c:when test="${empty historySearch.searchName}">
        <form action="/history_search" method="post">
            <div class="columns">
                <div class="column">
                    <div class="field has-addons">
                        <div class="control">
                            <input class="input" type="text" placeholder="nazwa analizy" name="historySearchName">
                        </div>
                        <div class="control">
                            <button class="button is-link">Zapisz analizę</button>
                        </div>
                    </div>
                </div>
                <div class="column">
                    <a class="button is-info is-light" href="/jumper_chart">
                        Pokaż wykres</a>
                </div>
                <div class="column"></div>
                <div class="column"></div>

            </div>

        </form>

        </c:when>
        <c:otherwise>
            <h4 class="title is-4"> Przeglądasz zapisaną analizę o nazwie: ${historySearch.searchName}
            </h4>
            <a class="button is-info is-light" href="/jumper_chart">
                Pokaż wykres</a>
        </c:otherwise>
        </c:choose>

    </div>
</section>
<section class="table list" style="margin-top: 0;">
    <div class="container">
        <div class="table-container">
            <table class="table is-striped is-hoverable is-fullwidth">
                <thead>
                <tr>
                    <th title="name">Imię i nazwisko</th>
                    <th title="origin">Kraj</th>
                    <th title="gold">Liczba zwycięstw</th>
                    <th title="silver">L.2. miejsc</th>
                    <th title="bronze">L.3. miejsc</th>
                    <th title="total">Suma punktów</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${jumperList}" var="jumper">
                    <tr>
                        <td>${jumper.athleteName}</td>
                        <td>${jumper.origin}</td>
                        <td>${jumper.goldMedals}</td>
                        <td>${jumper.silverMedals}</td>
                        <td>${jumper.bronzeMedals}</td>
                        <td>${jumper.totalPoints}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</section>
</body>
</html>