<!DOCTYPE html>
<html>
<head>
    <%@include file="../includes/header.jsp" %>
</head>
<body>
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-8">
                <form class="text-center border border-light p-5" method="post"
                    action="/dashboard"
                    th:action="@{/dashboard}"
                    th:object="${user}"
                >
                    <p class="h4 mb-4">Register</p>
                    <input type="text"  name="firstname" th:field="*{firstname}" class="form-control mb-4" placeholder="First name">
                    <input type="text" name="surname" th:field="*{surname}" class="form-control mb-4" placeholder="Last name">
                    <input type="email" name="email" th:field="*{email}" class="form-control mb-4" placeholder="E-mail">
                    <input type="password" name="password" th:field="*{password}" class="form-control mb-4" placeholder="Password">

                    <button class="btn btn-primary btn-block btn-lg" name="submit" type="submit">Sign up</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>