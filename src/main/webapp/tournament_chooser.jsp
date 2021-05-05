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

<nav class="navbar is-fixed-top">
    <jsp:include page="navbar.jsp"/>
</nav>
<!-- -------------------------------------------------------------------------------------------------------- -->
<form action="/selector_controller" method="post">
<section class="table list">
    <div class="container">
        <div class="table-container">
            <div class="control-panel container is-flex is-justify-content-space-between is-align-items-center">
                <p class="title is-3" style="margin: 0">
                    Wybierz konkursy do analizy:
                </p>
                <div class="is-flex is-justify-content-flex-start is-align-items-center">
                    <p class="title is-4" style="margin: 0">Analizuj według:</p>
                    <button type="submit" name="selector_btn" value="jumper" class="button is-primary is-link" style="margin-left: 10px">
                        Skoczek
                    </button>
                    <button type="submit" name="selector_btn" value="country" class="button is-primary is-link" style="margin-left: 10px">
                        Kraj
                    </button>
                </div>
            </div>
            <table class="table is-striped is-hoverable is-fullwidth">
                <thead>
                <tr>
                    <th title="check"></th>
                    <th title="date">Data</th>
                    <th title="place">Miejsce</th>
                    <th title="gender">Płeć</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${tournaments}" var="tournament">
                <tr>
                    <th><input type="checkbox" name="tournament_id" value="${tournament.id}"></th>
                    <th>${tournament.date}</th>
                    <th>${tournament.place}</th>
                    <th>${tournament.gender}</th>
                </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</section>
</form>
</body>
</html>