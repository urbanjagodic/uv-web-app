<%@include file="../includes/dashboard_header.jsp" %>
 <main class="mdl-layout__content">
   <div class="page-content">
        <div class="main-content">
            <p class="change_picture">Change profile picture</p>

            <img alt="avatar picture" id="avatar_image" class="change_avatar" src="${user.getAvatar()}"/>
            <br/>
            <br/>
            <!-- <form action="/dashboard/changeAvatar" method="post"
                th:action"@{/dashboard/changeAvatar}"
                th:object="${user}"
            > -->
                <label for="file_upload" class="mdl-button mdl-js-button mdl-button--raised">
                    Change picture
                </label>
                <input id="file_upload" name="avatar" th:field="*{avatar}" value="Change picture" onchange="previewFile()" type="file"/>
                <br/>
                <br/>
                <button onclick="postAvatar()" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                  Save
                </button>
                <button onclick="window.location='/dashboard'" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                  Cancel
                </button>
            <!-- </form> -->
        </div>
   </div>
 </main>
 <style>
    .change_picture {
        font-size: 20px;
    }
    .change_avatar {
        width: 250px;
        height: 250px;
    }
    input[type="file"] {
        display: none;
    }
 </style>
 <script>
    function previewFile(){
        var preview = document.getElementById("avatar_image");
        var file = document.getElementById("file_upload").files[0];
        var reader = new FileReader();
        reader.onloadend = function () {
            preview.src = reader.result;
        }
        if (file) {
            reader.readAsDataURL(file); //reads the data as a URL
        }
   }
   function postAvatar() {
        let base64 = document.getElementById("avatar_image").src;
        let fileName = document.getElementById("file_upload").value;

        if(fileName.endsWith(".png")) {

            let xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    window.location = "/dashboard";
                }
              };
            xhttp.open("POST", "/dashboard/changeAvatar", true);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("avatar=" + base64);
        }
   }

   previewFile();
  </script>
<%@include file="../includes/dashboard_footer.jsp" %>
