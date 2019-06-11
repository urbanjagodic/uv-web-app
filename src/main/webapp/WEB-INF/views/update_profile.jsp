<%@include file="../includes/dashboard_header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <main class="mdl-layout__content">
   <div class="page-content">
        <div class="main-content">
        <p class="title profile_info_title"> Update profile</p>
        <div>
            <form:form method="post"
                 action="/dashboard/updateProfile"
                 modelAttribute="user">
              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <form:input path="name" class="mdl-textfield__input" type="text" id="name" value="${user.getName()}"/>
                <label class="mdl-textfield__label" for="name">Name</label>
              </div>
              <br />
               <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <form:input path="surname" class="mdl-textfield__input" type="text" id="surname"/>
                  <label class="mdl-textfield__label" for="surname">Surname</label>
                </div>
                <br />
               <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <form:input path="email" class="mdl-textfield__input" type="email" id="email"/>
                  <label class="mdl-textfield__label" for="email">Email</label>
                </div>
                <br />
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <input name="old_password" class="mdl-textfield__input" type="password" id="password"/>
                  <label class="mdl-textfield__label" for="password">Enter old password</label>
                </div>
                <br />
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <input name="new_password" class="mdl-textfield__input" type="password" id="new_password"/>
                  <label class="mdl-textfield__label" for="new_password">Enter new password</label>
                </div>
                <br />
                 <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                  <input name="confirm_password" class="mdl-textfield__input" type="password" id="confirm_password"/>
                  <label class="mdl-textfield__label" for="confirm_password">Confirm new password</label>
                </div>
                <br />
              <button type="submit" name="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                Update profile
              </button>
            </form:form>
        </div>
        </div>
   </div>
 </main>
 <script>
 </script>
<%@include file="../includes/dashboard_footer.jsp" %>
<style>
    .profile_info_title {
        font-size: 27px;
    }
    .info {
        margin: 1%;
        font-size: 18px;
    }
</style>