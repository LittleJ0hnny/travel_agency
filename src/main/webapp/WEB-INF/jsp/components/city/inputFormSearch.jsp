<form method="post" action="${pageContext.request.contextPath}/cities/searchCitiesByName">
    <fieldset>
        <legend>Search city</legend>
        <div class="form-group">
            <input type="text" class="form-control" name ="name" placeholder="City name">
            <small class="form-text text-muted">Please input only string data.</small>
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </fieldset>
</form>