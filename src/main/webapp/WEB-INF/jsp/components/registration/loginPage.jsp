<form method="post" action="${pageContext.request.contextPath}/loginProcess">
    <fieldset>
        <legend>Login Page</legend>
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="text" class="form-control" id="email" name ="email" placeholder="e-mail">
            <small class="form-text text-muted">${emailMessage}</small>

            <label for="password">Password address</label>
            <input type="text" class="form-control" id="password" name ="password" placeholder="password">
            <small class="form-text text-muted">${passwordMessage}</small>

            <button type="submit" class="btn btn-primary">Login</button>
        </div>
    </fieldset>
</form>