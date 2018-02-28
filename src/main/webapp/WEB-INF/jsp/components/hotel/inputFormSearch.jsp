<form method="post" action="${pageContext.request.contextPath}/hotels/searchHotelsByName">
    <fieldset>
        <legend>Search hotel</legend>
        <div class="form-group">
            <label for="inputHotelName">Search country</label><input type="text" class="form-control" id="inputHotelName" name ="name" placeholder="Hotel name">
            <small class="form-text text-muted">Please input only string data.</small>
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </fieldset>
</form>