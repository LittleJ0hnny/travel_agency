<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="${pageContext.request.contextPath}/registrationProcess">
    <fieldset>
        <legend>Registration page</legend>
        <div class="form-group">

            <label for="email">Input your email address</label>
            <input type="email" class="form-control" id="email" name ="email" placeholder="e-mail">
            <small class="form-text text-muted">${emailMessage}</small>

            <label for="firstname">Input your name</label>
            <input type="text" class="form-control" id="firstname" name ="firstname" placeholder="firstname">

            <label for="lastname">Input your surname</label>
            <input type="text" class="form-control" id="lastname" name ="lastname" placeholder="lastname">

            <label for="birthday">Input your birthday</label>
            <input type="date" class="form-control" id="birthday" name ="birthday">

            <label for="citizenship">Input your citizenship</label>
            <select class="custom-select" id="citizenship" name="citizenship">
                <c:forEach var="country" items="${countries}">
                    <option value="${country.name}">${country.name}</option>
                </c:forEach>
            </select>

            <label for="password">Password</label>
            <input type="password" max="16" min="6" class="form-control" id="password" name ="password" placeholder="password">
            <small class="form-text text-muted">${passwordMessage}</small>

            <label for="passwordConfirm">Password</label>
            <input type="password" max="16" min="6" class="form-control" id="passwordConfirm" name ="password2" placeholder="confirm password">
            <small class="form-text text-muted">${passwordMessage}</small>

            <button type="submit" class="btn btn-primary">Sign in</button>
        </div>
    </fieldset>
</form>