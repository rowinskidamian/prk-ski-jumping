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
<!-- -------------------------------------------------------------------------------------------------------- -->
<form action="/selector_controller" method="get">
    <section class="hero is-info">
        <div class="hero-body">
            <div class="container">
                <h1 class="title">
                    Wybierz turnieje do analizy:
                </h1>
            </div>
        </div>
    </section>
    <section class="table list" style="margin-top: 10px">
    <div class="container">
        <div class="table-container" style="max-width: 1000px; margin: 0 auto">
            <div class="control-panel container is-flex is-justify-content-space-between is-align-items-center">
                <p class="title is-3" style="margin: 0">

                </p>
                <div class="is-flex is-justify-content-flex-start is-align-items-center">
                    <p class="title is-4" style="margin: 0">Analizuj według:</p>
                    <button type="submit" name="jumper_btn" value="jumper" class="button is-primary is-link" style="margin-left: 10px">
                        Skoczek
                    </button>
                    <button type="submit" name="country_btn" value="country" class="button is-primary is-link" style="margin-left: 10px">
                        Kraj
                    </button>
                </div>
            </div>
            <table class="table is-striped is-hoverable is-fullwidth" style="max-width: 800px; margin: 0 auto">
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