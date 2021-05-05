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
<form>
    <section class="table list">
        <div class="container">
            <div class="table-container">
                <div class="control-panel container is-flex is-justify-content-space-between is-align-items-center">
                    <p class="title is-3" style="margin: 0">
                        Wybierz skoczków do analizy:
                    </p>

                </div>
            </div>
                <table class="table is-striped is-hoverable is-fullwidth">
                    <thead>
                    <tr>
                        <th title="check"></th>
                        <th title="date">Skoczkowie</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${analyzedJumpers}" var="jumper">
                        <tr>
                            <th><input type="checkbox" name="selected_jumper" value="${jumper}"></th>
                            <th>${jumper}</th>
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