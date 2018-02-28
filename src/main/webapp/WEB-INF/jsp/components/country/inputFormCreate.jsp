<form method="post" action="${pageContext.request.contextPath}/countries/createCountry">
    <fieldset>
        <legend>Add country</legend>
        <div class="form-group">
            <label for="inputCountryName">Country name</label><input type="text" class="form-control" id="inputCountryName" name ="name" placeholder="Country name">
            <small class="form-text text-muted">Please input only string data.</small>
            <button type="submit" class="btn btn-primary">Make</button>
        </div>
    </fieldset>
</form>