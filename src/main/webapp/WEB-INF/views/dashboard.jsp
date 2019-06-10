<%@include file="../includes/dashboard_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <main class="mdl-layout__content">
   <div class="page-content">
        <div class="main-content">

            <c:if test="${not empty topics}">
                <c:forEach items="${topics}" var="topic">
                    <div class="my_card">
                        <div class="demo-card-square mdl-card mdl-shadow--2dp">
                          <div class="mdl-card__title mdl-card--expand">
                            <h2 class="mdl-card__title-text">${topic.getName()}</h2>
                          </div>
                          <div class="mdl-card__supporting-text">
                            ${topic.getDescription()}
                          </div>
                          <div class="mdl-card__actions mdl-card--border">
                            <a href="/dashboard/courses?id=${topic.getId()}"
                            class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                              View courses
                            </a>
                          </div>
                        </div>
                    </div>
                    <br />
                    <br />
            </c:forEach>
            </c:if>

        </div>
   </div>
 </main>
 <style>
    <!-- Square card -->
    <style>
    .demo-card-square.mdl-card {
      width: 100px;
      height: 320px;
    }
    .demo-card-square > .mdl-card__title {
      color: #fff;
      background: #3f51b5;
    }
    .my_card {
        margin-left: 25%;
    }
  </style>
<%@include file="../includes/dashboard_footer.jsp" %>
