<%--autor:Damian Rowiński--%>
<div class="container" id="wrapper">
    <div class="navbar-brand">
        <img src="logo/logo.png" class="logo" alt="PRK Ski Jumping logo"/>
    </div>

    <div id="navMenu" class="navbar-menu">
        <div class="navbar-start">
            <a class="navbar-item" href="${pageContext.request.contextPath}/homepage">Strona główna</a>
            <a class="navbar-item" href="${pageContext.request.contextPath}/database_admin">Panel administratora</a>

        </div>

        <div class="navbar-end">
            <div class="navbar-item">
                <div class="buttons">
                    <a class="button is-info" href="${pageContext.request.contextPath}/tournament_chooser">
                        <strong>Rozpocznij analizę</strong>
                    </a>
                    <a class="button is-light" href="${pageContext.request.contextPath}/history_search">Historia analiz</a>
                </div>
            </div>
        </div>
    </div>
</div>
