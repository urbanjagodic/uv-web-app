<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="../includes/header.jsp" %>
</head>
<body>
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-8">
                <form:form class="text-center border border-light p-5" method="post"
                    action="/register"
                    modelAttribute="user"
                >
                    <p class="h4 mb-4">Register</p>
                    <form:input type="text"  name="name" path="name" class="form-control mb-4" placeholder="First name"/>
                    <form:input type="text" name="surname" path="surname" class="form-control mb-4" placeholder="Last name"/>
                    <form:input type="email" name="email" path="email" class="form-control mb-4" placeholder="E-mail"/>
                    <form:input type="password" name="password" path="password" class="form-control mb-4" placeholder="Password"/>

                    <button class="btn btn-primary btn-block btn-lg" name="submit" type="submit">Sign up</button>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>