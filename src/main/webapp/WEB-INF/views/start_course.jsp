<%@include file="../includes/dashboard_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <main class="mdl-layout__content">
   <div class="page-content">
        <div class="main-content">

            <div class="course_div">
                <p class="c_title">${course.getTitle()}</p>
                <p class="c_description"> ${course.getDescription()}</p>
            </div>
        </div>
   </div>
 </main>
 <style>
    .course_div {
        padding: 2%;
        margin: 3% auto;
        width: 85%;
        background-color: white;
        border-radius: 3%;
    }
    .c_title {
        margin: 4% 4% 5% 4%;
        font-size: 23px;
        font-weight: bold;
    }
    .c_description {
        margin: 4%;
        font-size: 18px;
    }
  </style>
<%@include file="../includes/dashboard_footer.jsp" %>
