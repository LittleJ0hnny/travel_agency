<form method="post" action="${pageContext.request.contextPath}/countries/getCountryById">
    <fieldset>
        <legend>Search by id</legend>
        <div class="form-group">
            <label for="inputCountryId">Country id</label>
            <input type="number" class="form-control" id="inputCountryId" name ="id" placeholder="Id">
            <small class="form-text text-muted">Please input type integer numbers.</small>
            <button type="submit" class="btn btn-primary">Make</button>
        </div>
    </fieldset>
</form>