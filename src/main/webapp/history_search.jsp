<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Ski Jumping Analyzer - Historia analiz</title>
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
                <p class="title is-3" style="margin: 0">Zapisane analizy:</p>
            </div>
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
                            <c:if test="${historySearch eq 'Skoczek'}">
                                <c:set var="resultPage" scope="request" value="jumper_result"/>
                            </c:if>
                            <c:if test="${historySearch eq 'Kraj'}">
                                <c:set var="resultPage" scope="request" value="country_result"/>
                            </c:if>
                            <button href="/${resultPage}?historySearch=${historySearch.id}"
                                    class="button is-info is-light">Wyświetl</button></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</section>
</body>
</html>