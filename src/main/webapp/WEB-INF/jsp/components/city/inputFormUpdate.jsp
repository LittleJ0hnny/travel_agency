<form method="get" action="${pageContext.request.contextPath}/cities/saveUpdatedCity/${objectToUpdate.id}">
    <fieldset>
        <legend>Update city ${objectToUpdate.name}</legend>
        <div class="form-group">
            <label for="inputCityName">City name</label><input type="text" class="form-control" id="inputCityName" name ="name" placeholder="${objectToUpdate.name}">
            <small class="form-text text-muted">Please input only string data.</small>
            <label for="inputCityCountryName">Country id</label><input type="number" class="form-control" id="inputCityCountryName" name ="idOfCountry" placeholder="${objectToUpdate.country.id}">
            <button type="submit" class="btn btn-primary">Make</button>
        </div>
    </fieldset>
</form>