<%@ page import="java.time.LocalDate" %>
<form method="post" action="${pageContext.request.contextPath}/rooms/roomStatistic">
    <fieldset>
        <legend>Search free rooms</legend>
        <div class="form-group">
            <label for="inputDateFrom">Date from</label><input type="date" class="form-control" id="inputDateFrom" name ="dateFrom" placeholder="Date from"">
            <label for="inputDateTo">Date to</label><input type="date" class="form-control" id="inputDateTo" name ="dateTo" placeholder="Date to"">
            <input type="hidden" name="hotelId" value="${hotelId}">
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </fieldset>
</form>