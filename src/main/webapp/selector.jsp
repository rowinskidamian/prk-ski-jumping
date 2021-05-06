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
<form action="/${view}_result" method="get">
    <section class="table list">
        <div class="container">
            <div class="table-container" style="max-width: 1000px; margin: 0 auto">
                <div class="control-panel container is-flex is-justify-content-space-between is-align-items-center">
                    <p class="title is-3" style="margin: 0">
                        Wybierz do analizy:
                    </p>
                    <div class="is-flex is-justify-content-flex-start is-align-items-center">
                        <button type="submit" name="selector_btn" value="value" class="button is-primary is-link" style="margin-left: 10px">
                            Pokaż analizę
                        </button>
                    </div>
                </div>
            </div>
                <table class="table is-striped is-hoverable is-fullwidth" style="max-width: 800px; margin: 0 auto">
                    <thead>
                    <tr>
                        <th title="check"></th>
                        <th title="date"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${items}" var="item">
                        <tr>
                            <th><input type="checkbox" name="selected_item" value="${item}"></th>
                            <th>${item}</th>
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