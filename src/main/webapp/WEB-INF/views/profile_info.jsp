<%@include file="../includes/dashboard_header.jsp" %>
 <main class="mdl-layout__content">
   <div class="page-content">
        <div class="main-content">
        <p class="title profile_info_title"> Profile information</p>
        <div>
            <p class="info"><b>Avatar:</b> </p>
            <br />
            <img src="${user.getAvatar()}" style=" width: 200px; height: 200px" />
            <br/>
            <br/>
            <p class="info"><b>Name:</b> ${user.getName()} ${user.getSurname()} </p>
            <br />
            <p class="info"><b>Email:</b> ${user.getEmail()} </p>
            <br />
            <p class="info"><b>Password:</b> <span id="password">${user.getPassword()} </span> </p>
             <button id="button_password" onclick="showOrHide()" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
              Show password
            </button>
        </div>
        </div>
   </div>
 </main>
 <script>
    let password = document.getElementById("password");
    let button = document.getElementById("button_password");
    let initialValue = password.textContent;
    password.textContent = returnMask(password.textContent.length);

    let flag = false;
    function showOrHide() {
        if(flag) {
            password.textContent = returnMask(password.textContent.length);
            button.textContent = "Show password";
            flag = false;
        }
        else {
            password.textContent = initialValue;
            button.textContent = "Hide password";
            flag = true;
        }
    }
    function returnMask(length) {
        let mask = "";
        for(let i = 1; i < length; i++) {
            mask += "*";
        }
        return mask;
    }

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