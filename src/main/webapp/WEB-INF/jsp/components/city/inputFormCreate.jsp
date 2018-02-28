<form method="post" action="${pageContext.request.contextPath}/cities/createCity">
    <fieldset>
        <legend>Add city</legend>
        <div class="form-group">
            <label for="inputCityName">City name</label><input type="text" class="form-control" id="inputCityName" name ="name" placeholder="City name">
            <small class="form-text text-muted">Please input only string data.</small>
            <label for="inputCityCountryName">Country id</label><input type="number" class="form-control" id="inputCityCountryName" name ="idOfCountry" placeholder="Country ID">
            <small class="form-text text-muted">Please input only integer data.</small>
            <button type="submit" class="btn btn-primary">Make</button>
        </div>
    </fieldset>
</form>