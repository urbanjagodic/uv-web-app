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
        <p class="headline"><b> ${ String.format("%s %s", user.getName(), user.getSurname()) }</b></p>
       </div>
       <nav class="mdl-navigation">
         <a class="mdl-navigation__link" href="">Profile info</a>
         <a class="mdl-navigation__link" href="">Your courses</a>
         <a class="mdl-navigation__link" href="">Settings</a>
       </nav>
     </div>