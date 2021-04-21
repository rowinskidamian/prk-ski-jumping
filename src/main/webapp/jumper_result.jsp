<%--
  Created by IntelliJ IDEA.
  User: Radek
  Date: 21.04.2021
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.2/css/bulma.min.css"/>
    <link rel="stylesheet" href="./style/style.css"/>
    <title>Ski Jumping Analyzer</title>
</head>
<body>
<nav class="navbar is-fixed-top">
    <div class="container">
        <div class="navbar-brand">
            <img src="./logo/logo.png" class="logo"/>
        </div>

        <div id="navMenu" class="navbar-menu">
            <div class="navbar-start">
                <a class="navbar-item" href="index.html">Strona główna</a>
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
<section class="table list">
    <div class="container">
        <div class="table-container">
            <div class="control-panel container is-flex is-justify-content-space-between is-align-items-center">
                <p class="title is-3" style="margin: 0">
                    Wyniki skoczków z wybranych konkursów:
                </p>
            </div>
            <table class="table is-striped is-hoverable is-fullwidth">
                <thead>
                <tr>
                    <th title="rank">Rank</th>
                    <th title="name">Athlete</th>
                    <th title="origin">Origin</th>
                    <th title="gold">Gold</th>
                    <th title="silver">Silver</th>
                    <th title="bronze">Bronze</th>
                    <th title="total">Total points</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>1</th>
                    <th>${fromInput}</th>
                    <th>JPN</th>
                    <th>3</th>
                    <th>1</th>
                    <th>1</th>
                    <th>299,86</th>
                </tr>

                </tbody>
            </table>
            <div class="container is-flex is-justify-content-flex-start is-align-items-center">
                <input type="text" style="font-size: 1rem; padding: 5px" placeholder="nazwa"/>
                <a href="HistorySearch.html" class="button is-primary is-link" style="margin-left: 30px">
                    Zapisz analizę
                </a>
            </div>
        </div>
    </div>
</section>
</body>
</html>
