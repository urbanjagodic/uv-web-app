<!DOCTYPE html>
<html>
<head>
    <%@include file="../includes/header.jsp" %>
</head>
<body>
   <!-- Always shows a header, even in smaller screens. -->
   <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header primary">
     <header class="mdl-layout__header">
       <div class="mdl-layout__header-row">
         <!-- Title -->
         <span class="mdl-layout-title">Courses app</span>
         <!-- Add spacer, to align navigation to the right -->
         <div class="mdl-layout-spacer"></div>
         <!-- Navigation. We hide it in small screens. -->
         <nav class="mdl-navigation mdl-layout--large-screen-only">
           <a class="mdl-navigation__link" href="/logout">Log out</a>
         </nav>
       </div>
     </header>
     <div class="mdl-layout__drawer">
       <span class="mdl-layout-title">Profile</span>
       <div class="avatar_section">
        <img id="avatar" src="${user.getAvatar()}" onclick="window.location='/dashboard/changeAvatar'" />
        <div class="mdl-tooltip mdl-tooltip--large" data-mdl-for="avatar">
            Change profile picture
        </div>
        <p class="headline user_name"><b> ${ String.format("%s %s", user.getName(), user.getSurname()) }</b></p>
       </div>
       <nav class="mdl-navigation">
         <a class="mdl-navigation__link" href="/dashboard">Home</a>
         <a class="mdl-navigation__link" id="profile_info_link" href="/dashboard/profileInfo">Profile info</a>
          <div class="mdl-tooltip mdl-tooltip--large" data-mdl-for="profile_info_link">
             See profile information
            </div>
         <a id="your_courses_link" class="mdl-navigation__link" href="/dashboard/yourCourses">Your courses</a>
           <div class="mdl-tooltip mdl-tooltip--large" data-mdl-for="your_courses_link">
              Checkout your courses
             </div>
          <a id="create_course_link" class="mdl-navigation__link" href="/dashboard/newCourse">Create a new course</a>
           <div class="mdl-tooltip mdl-tooltip--large" data-mdl-for="create_course_link">
                Create a custom topic course
          </div>
         <a id="profile_settings_link" class="mdl-navigation__link" href="/dashboard/updateProfile"">Settings</a>
         <div class="mdl-tooltip mdl-tooltip--large" data-mdl-for="profile_settings_link">
           Update your profile
          </div>
       </nav>
     </div>