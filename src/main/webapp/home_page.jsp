<%--autor:Radosław Parol--%>
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
<section class="hero is-info is-fullheight">
    <div class="hero-body">
        <div class="container">
            <p class="title is-1">Witaj w Ski Jumping Analyzer</p>
            <p class="subtitle is-4">
                Miejscu gdzie możesz dokonać analizy ostatnich wyników turniejów w
                skokach narciarskich!
            </p>
        </div>
    </div>
</section>
</body>
</html>
