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


<nav class="navbar" style="padding: 20px 0">
    <jsp:include page="navbar.jsp"/>
</nav>
<!-- -------------------------------------------------------------------------------------------------------- -->
<section class="container">
    <section class="hero is-info">
        <div class="hero-body">
            <div class="container">
                <h1 class="title">
                    Panel administratora
                </h1>
            </div>
        </div>
    </section>
        <table class="table is-striped" style="margin: 50px auto; width: 70%">
            <tbody>
                <tr>
                    <form method="get" action="${pageContext.request.contextPath}/database_init">
                        <th>Wgraj dużo danych</th>
                        <th>operacja wgrywa wszystkie dane do bazy</th>
                        <th><Button type="submit" class="button is-info" >wykonaj</Button></th>
                    </form>
                </tr>
                <tr>
                    <form method="get" action="${pageContext.request.contextPath}/database_load_small">
                        <th>Wgraj małą partię</th>
                        <th><input style="max-width: 200px;" name="tournamentAmount" class="input is-info" type="number" placeholder="podaj ilość"></th>
                        <th><Button type="submit" class="button is-info">wykonaj</Button></th>
                    </form>
                </tr>
                <tr>
                    <form method="get" action="${pageContext.request.contextPath}/database_load_small">
                        <th>Wgraj minimalną partię</th>
                        <th>operacja wgrywa 5 turniejów</th>
                        <th><Button type="submit" class="button is-info">wykonaj</Button></th>
                    </form>
                </tr>
                <tr>
                    <form method="get" action="${pageContext.request.contextPath}/database_clean">
                        <th>Wyczyść bazę danych</th>
                        <th>operacja czyści bazę danych</th>
                        <th><Button type="submit" class="button is-danger">wykonaj</Button></th>
                    </form>
                </tr>
            </tbody>
        </table>
    <table class="table is-bordered" style="margin: 50px auto; width: 35%">
        <tbody>
            <tr>
                <th>Ilość turniejów w bazie</th>
                <th>${twc}</th>
            </tr>
            <tr>
                <th>Ilość rezultatów z turniejów w bazie</th>
                <th>${tjr}</th>
            </tr>
        </tbody>
    </table>
</section>
</body>
</html>
