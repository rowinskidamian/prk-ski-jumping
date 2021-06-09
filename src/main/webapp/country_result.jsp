<%--autor:Damian Rowiński--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.2/css/bulma.min.css"/>
  <link rel="stylesheet" href="./style/style.css" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.2.0/chart.min.js" integrity="sha512-VMsZqo0ar06BMtg0tPsdgRADvl0kDHpTbugCBBrL55KmucH6hP9zWdLIWY//OTfMnzz6xWQRxQqsUFefwHuHyg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <title>Ski Jumping Analyzer</title>
  <style>
    .hide {
      display: none;
    }
  </style>
</head>
<body>
<nav class="navbar" style="padding: 20px 0">
  <jsp:include page="navbar.jsp"/>
</nav>

<section class="hero is-info">
  <div class="hero-body">
    <div class="container">
      <h1 class="title">
        Wyniki krajów z wybranych konkursów
      </h1>
    </div>
  </div>
</section>
<section class="section">
  <div class="container">


    <c:choose>
      <c:when test="${empty historySearch.searchName}">
        <form action="/history_search" method="post">
          <div class="field has-addons" style="position: relative">
            <div class="control">
              <input class="input" type="text" placeholder="nazwa analizy" name="historySearchName">
            </div>
            <div class="control">
              <button class="button is-link">Zapisz analizę</button>
            </div>
            <div class="control-btn button is-primary is-link" style="margin-right: 90px; position: absolute; right: 0" >
              Pokaż wykres
            </div>
          </div>
        </form>
      </c:when>
      <c:otherwise>
        <h4 class="title is-4"> Przeglądasz zapisaną analizę o nazwie: ${historySearch.searchName}
        </h4>
        <div class="control-btn button is-primary is-link" style="margin-left: 10px;" >
          Pokaż wykres
        </div>
      </c:otherwise>
    </c:choose>

  </div>
</section>
<section class=" table list" style="margin-top: 0;">
  <div class="container">
    <div class="table-container">
      <table class=" table is-striped is-hoverable is-fullwidth">
        <thead>
        <tr>
          <th title="origin">Nazwa kraju</th>
          <th title="gold">Liczba zwycięstw</th>
          <th title="silver">L.2. miejsc</th>
          <th title="bronze">L.3. miejsc</th>
          <th title="total">Suma punktów</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${countryList}" var="country">
          <tr>
            <td class="chart-label">${country.name}</td>
            <td>${country.goldMedals}</td>
            <td>${country.silverMedals}</td>
            <td>${country.bronzeMedals}</td>
            <td class="chart-points">${country.totalPoints}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>

</section>

<div class="chart-container hide"  style="margin: 70px auto; max-width: 700px">
  <canvas id="myChart"></canvas>
</div>
<script>
  let btn = document.querySelector(".control-btn");
  let chartContainer = document.querySelector(".chart-container");
  let tableContainer = document.querySelector(".table-container");

  btn.addEventListener("click", () => {
    chartContainer.classList.toggle("hide");
    tableContainer.classList.toggle("hide");
    if (btn.innerText.toLowerCase() === "pokaż wykres") {
      btn.innerText = "Pokaż tabelę"
    } else {
      btn.innerHTML = "Pokaż wykres";
    }

  })

</script>
<script src="chart.js"></script>
</body>
</html>