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
                Zapisane analizy
            </h1>
        </div>
    </div>
</section>


<section class="table list">
    <div class="container">
        <div class="table-container">

            <table class="table is-striped is-hoverable is-fullwidth">
                <thead>
                <tr>
                    <th title="date">Data zapisania</th>
                    <th title="date">Nazwa</th>
                    <th title="place">Typ</th>
                    <th title="gender">Liczba konkursów</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${historyList}" var="historySearch">
                    <tr>
                        <td>${historySearch.searchDate}</td>
                        <td>${historySearch.searchName}</td>
                        <td>${historySearch.searchType}</td>
                        <td>${historySearch.tournamentAmount}</td>
                        <td>
                            <c:if test="${historySearch.searchType eq 'Skoczek'}">
                                <c:set var="resultPage" scope="request" value="jumper_result"/>
                            </c:if>
                            <c:if test="${historySearch.searchType eq 'Kraj'}">
                                <c:set var="resultPage" scope="request" value="country_result"/>
                            </c:if>
                            <a class="button is-info is-light" href="/${resultPage}?historySearch=${historySearch.id}">
                                Wyświetl</a></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</section>
</body>
</html>