<form method="post" action="${pageContext.request.contextPath}/countries/searchCountriesByName">
    <fieldset>
        <legend>Search country</legend>
        <div class="form-group">
            <input type="text" class="form-control" name ="name" placeholder="Country name">
            <small class="form-text text-muted">Please input only string data.</small>
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </fieldset>
</form>