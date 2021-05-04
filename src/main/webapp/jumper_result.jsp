<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Ski Jumping Analyzer - Wyniki dla skoczków</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.2/css/bulma.min.css"/>
    <link rel="stylesheet" href="./style/style.css"/>
</head>
<body class="has-navbar-fixed-top">
<nav class="navbar is-fixed-top">
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
            <div class="field has-addons">
                <div class="control">
                    <input class="input" type="text" placeholder="nazwa analizy" name="historySearchName">
                </div>
                <div class="control">
                    <button class="button is-link">Zapisz analizę</button>
                </div>
            </div>
        </form>
        </c:when>
        <c:otherwise>
            <h4 class="title is-4"> Przeglądasz zapisaną analizę o nazwie: ${historySearch.searchName}
            </h4>
        </c:otherwise>
        </c:choose>
    </div>
</section>
<section class="table list">
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