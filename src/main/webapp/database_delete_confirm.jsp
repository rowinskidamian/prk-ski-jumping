<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
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
                Baza danych - potwierdź usunięcie danych
            </h1>
        </div>
    </div>
</section>
<section class="section">
    <div class="container">
        <div class="block has-text-centered">
            Czy potwierdzasz usunięcie danych z bazy?
        </div>
        <div class="field is-grouped is-grouped-centered">
            <form method="post" action="/database_clean">
            <p class="control">
                <button class="button is-primary" type="submit">
                    TAK
                </button>
            </p>
            </form>
            <p class="control">
                <a class="button is-light" href="/database_admin">
                    NIE
                </a>
            </p>
        </div>
    </div>

</section>
</body>
</html>