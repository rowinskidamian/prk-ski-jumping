<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Ski Jumping Analyzer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.2/css/bulma.min.css" />
    <link rel="stylesheet" href="./style/style.css"/>
</head>
<body>
<nav class="navbar is-fixed-top">
    <div class="container" id="wrapper">
        <div class="navbar-brand">
            <img src="./logo/logo.png" class="logo"/>
        </div>

        <div id="navMenu" class="navbar-menu">
            <div class="navbar-start">
                <a class="navbar-item">Strona główna</a>
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
<section class="hero is-info is-fullheight">
    <div class="hero-body">
        <div class="container">
            <p class="title is-1">Witaj w Ski Jumping Analyzer</p>
            <p class="subtitle is-4">
<%--                Miejscu gdzie możesz dokonać analizy ostatnich wyników turniejów w--%>
<%--                skokach narciarskich!--%>
    ${country1.name}
            </p>
        </div>
    </div>
</section>


</body>
</html>