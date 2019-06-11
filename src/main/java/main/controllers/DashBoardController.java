package main.controllers;

import main.*;
import main.db_methods.CourseMethods;
import main.db_methods.TopicMethods;
import main.db_methods.UserMethods;
import main.utils.Logger;
import main.utils.Utils;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
public class DashBoardController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private TopicRepository topicRepo;
    @Autowired
    private CourseRepository courseRepo;

    // Gets userID from login or register page
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashBoard(Model model, HttpSession session) {
        User currentUser =  (User) session.getAttribute("user");
        if(currentUser != null) {
            model.addAttribute("user", currentUser);
            TopicMethods topicMethods = new TopicMethods(topicRepo);
            List<Topic> topics = topicMethods.getTopics();
            model.addAttribute("topics", topics);
            return "dashboard";
        }
        return "not_authorized";
    }

    @RequestMapping(value = "/dashboard/changeAvatar",method = RequestMethod.GET)
    public String changeAvatar(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user != null) {
            model.addAttribute("user", user);
            return "change_avatar";
        }
        return "not_authorized";
    }

    @RequestMapping(value = "/dashboard/changeAvatar",method = RequestMethod.POST)
    public String changeAvatarPost(@RequestParam("avatar") String avatar, Model model, HttpSession session) {

        UserMethods userMethods = new UserMethods(userRepo);
        User user = (User) session.getAttribute("user");
        if(user != null) {
            avatar = avatar.replace(" ", "+");
            User updatedUser = userMethods.changeAvatar(user.getId(), avatar);
            Logger.log(Logger.TYPE.INFO, String.format("User image updated for user %s", user.getId()));
            session.setAttribute("user", updatedUser);
            return "redirect:/dashboard";
        }
        return "not_authorized";
    }

    @RequestMapping(value ="/dashboard/profileInfo", method = RequestMethod.GET)
    public String profileInfoPage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user != null) {
            model.addAttribute("user", user);
            return "profile_info";
        }
        return "not_authorized";
    }

    @RequestMapping(value = "/dashboard/courses", method = RequestMethod.GET)
    public String courses(@RequestParam("id") String id, Model model, HttpSession session) {
        String topicID = id;
        return "neki";
    }


    @RequestMapping(value = "/dashboard/newCourse", method = RequestMethod.GET)
    public String courses(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user != null) {
            TopicMethods topicMethods = new TopicMethods(topicRepo);
            List<String> topicNames = topicMethods.getTopicNames();
            Course newCourse = new Course();
            model.addAttribute("course", newCourse);
            model.addAttribute("topics", topicNames);
            return "new_course";
        }
        return "not_authorized";
    }

    @RequestMapping(value = "/dashboard/newCourse", method = RequestMethod.POST)
    public String coursesPost(@Valid @ModelAttribute("course") Course course, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user != null) {
            TopicMethods topicMethods = new TopicMethods(topicRepo);
            CourseMethods courseMethods = new CourseMethods(courseRepo);
            String topicID = String.valueOf(topicMethods.returnIdByName(course.getTopicID()));
            course.setUserID(user.getId());
            course.setTopicID(topicID);

            if(!(Utils.isNull(course.getTitle()) || Utils.isNull(course.getDescription()) ||
                    Utils.isNull(course.getTopicID()))) {
                courseMethods.addNewCourse(course);
                return "redirect:/dashboard";
            }
            else {
                return "redirect:/dashboard/newCourse";
            }
        }
        return "not_authorized";
    }

    @RequestMapping(value = "/dashboard/updateProfile", method = RequestMethod.GET)
    public String updateProfile(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user != null) {
            model.addAttribute("user", user);
            return "update_profile";
        }
        return "not_authorized";
    }

    @RequestMapping(value = "/dashboard/updateProfile", method = RequestMethod.POST)
    public String coursesPost(@Valid @ModelAttribute("user") User user,
                              @RequestParam("old_password") String oldPassword,
                              @RequestParam("new_password") String newPassword,
                              @RequestParam("confirm_password") String confirmPassword,
                              Model model, HttpSession session) {
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser != null) {
            if(sessionUser.getPassword().equals(oldPassword)) {
                if(newPassword.equals(confirmPassword)) {
                    user.setAvatar(sessionUser.getAvatar());
                    user.setId(sessionUser.getId());
                    user.setPassword(confirmPassword);
                    UserMethods userMethods = new UserMethods(userRepo);
                    userMethods.updateUser(user);
                    session.setAttribute("user", user);
                    Logger.log(Logger.TYPE.ERROR, "User info updated");
                    return "redirect:/dashboard";
                }
                else {
                    Logger.log(Logger.TYPE.ERROR, "Entered passwords do not match");
                    return "redirect:/dashboard/updateProfile";
                }

            }
            else {
                Logger.log(Logger.TYPE.ERROR, "Old password is not correct");
                return "redirect:/dashboard/updateProfile";
            }
        }
        return "not_authorized";
    }



}
