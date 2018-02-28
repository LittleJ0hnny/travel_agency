<form method="post" action="${pageContext.request.contextPath}/cities/getCityById">
    <fieldset>
        <legend>Search by id</legend>
        <div class="form-group">
            <label for="inputCityId">City id</label>
            <input type="number" class="form-control" id="inputCityId" name ="id" placeholder="Id">
            <small class="form-text text-muted">Please input type integer numbers.</small>
            <button type="submit" class="btn btn-primary">Make</button>
        </div>
    </fieldset>
</form>