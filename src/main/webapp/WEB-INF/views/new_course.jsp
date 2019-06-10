<%@include file="../includes/dashboard_header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <main class="mdl-layout__content">
   <div class="page-content">
        <div class="main-content">
            <p class="title_new_course headline">Create a new course</p>
               <form:form method="post"
                 action="/dashboard/newCourse"
                 modelAttribute="course">
              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <form:input path="title" class="mdl-textfield__input" type="text" id="title"/>
                <label class="mdl-textfield__label" for="title">Title</label>
              </div>
              <br />
               <div class="mdl-textfield mdl-js-textfield">
                    <form:textarea path="description" class="mdl-textfield__input" type="text" rows= "5" id="sample5" ></form:textarea>
                  <label class="mdl-textfield__label" for="sample5">Description</label>
                </div>
                 <div class="form-group">
                    <label for="exampleSelect1" class="bmd-label-floating">Select course topic</label>
                     <form:select path="topicID" class="form-control" id="exampleSelect1">
                           <form:options items="${topics}" />
                    </form:select>
                    </select>
                  </div>
                  <br />
                  <button type="submit" name="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                        Add a new course
                  </button>
            </form:form>
        </div>
   </div>
 </main>
 <style>
    .title_new_course {
        font-size: 24px;
        margin-bottom: 2%;
    }
  </style>
<%@include file="../includes/dashboard_footer.jsp" %>
