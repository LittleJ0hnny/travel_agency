<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Welcome to Booking.ua</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor01">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/countries"> Countries</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/cities"> Cities</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Statistic</a>
                <div class="dropdown-menu" x-placement="bottom-start" style="position: absolute; transform: translate3d(0px, 40px, 0px); top: 0px; left: 0px; will-change: transform;">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/hotels/statistic">Show Hotel Statistic</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/clients/statistic">Show Client Statistic</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/countries/statistic">Show Countries Statistic</a>
                </div>
            </li>
        </ul>
    </div>
</nav>