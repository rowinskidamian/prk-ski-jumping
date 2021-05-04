<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Ski Jumping Analyzer - Wyniki dla skoczków</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.2/css/bulma.min.css" />
    <link rel="stylesheet" href="./style/style.css"/>
</head>
<body>
<nav class="navbar is-fixed-top">
    <jsp:include page="WEB-INF/navbar.jsp"/>
</nav>
<!-- -------------------------------------------------------------------------------------------------------- -->
<section class="table list">
    <div class="container">
        <div class="table-container">

            <div class="control-panel container is-flex is-justify-content-space-between is-align-items-center">
                <p class="title is-3" style="margin: 0">
                    Wyniki skoczków z wybranych konkursów:
                </p>
            </div>
            <div class="container is-flex is-justify-content-flex-start is-align-items-center">
                <form action="/history_search" method="post">
                <input type="text" style="font-size: 1rem; padding: 5px" name="historySearchName" placeholder="nazwa"/>
                    <div class="control">
                        <button class="button is-link">Zapisz analizę</button>
                    </div>
                </form>
            </div>
            <div class="container">
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
                            <th>${jumper.athleteName}</th>
                            <th>${jumper.origin}</th>
                            <th>${jumper.goldMedals}</th>
                            <th>${jumper.silverMedals}</th>
                            <th>${jumper.bronzeMedals}</th>
                            <th>${jumper.totalPoints}</th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
</body>
</html>