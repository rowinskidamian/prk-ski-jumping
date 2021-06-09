<%--autor:Damian Rowiński--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.2/css/bulma.min.css"/>
    <link rel="stylesheet" href="./style/style.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.2.0/chart.min.js"
            integrity="sha512-VMsZqo0ar06BMtg0tPsdgRADvl0kDHpTbugCBBrL55KmucH6hP9zWdLIWY//OTfMnzz6xWQRxQqsUFefwHuHyg=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
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
                Wyniki skoczków - wykres punktów
            </h1>
        </div>
    </div>
</section>
<section class="section">
    <div class="container">
        <canvas id="myChart" width="600" height="200"></canvas>
        <p id="jsonData" data-json='${jumperJson}'></p>
    </div>
</section>

<script src="jumper_chart.js" type="text/javascript">

</script>

</body>
</html>