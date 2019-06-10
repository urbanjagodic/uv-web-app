<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="../includes/header.jsp" %>
</head>
<body>
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-8 login_form">
                <form:form class="text-center border border-light p-5" method="post"
                    action="/login"
                    modelAttribute="login"
                >
                    <p class="h4 mb-4">Sign in</p>
                    <form:input type="email" path="email" class="form-control mb-4" placeholder="E-mail"/>
                    <form:input type="password" path="password" class="form-control mb-4" placeholder="Password"/>

                    <div class="d-flex justify-content-around">
                        <div>
                            <!-- Remember me -->
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                                <label class="custom-control-label" for="defaultLoginFormRemember">Remember me</label>
                            </div>
                        </div>
                        <div>
                            <!-- Forgot password -->
                            <a href="">Forgot password?</a>
                        </div>
                    </div>

                    <button class="btn btn-primary btn-block btn-lg" name="submit" type="submit">Sign in</button>
                    <p>Not a member?
                        <a href="/register">Register</a>
                    </p>
                </form:form>
            </div>
        </div>
    </div>
</body>
<style>
    .login_form {
        margin-top: 10%;
    }
</style>
</html>