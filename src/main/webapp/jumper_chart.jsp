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
                Wyniki skoczków - wykres punktów
            </h1>
        </div>
    </div>
</section>
<section class="section">
    <div class="container">
        <h4 class="title is-4"> Tutaj będą wyniki </h4>
        <p id="json"></p>
    </div>
</section>

<script>
    let json = '${jumperJson}';
    console.log(json);
</script>
</body>
</html>