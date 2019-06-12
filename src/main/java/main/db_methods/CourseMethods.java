package main.db_methods;

import main.Course;
import main.CourseRepository;
import main.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseMethods {

    private CourseRepository repo;
    private UserMethods userMethods;

    public CourseMethods(CourseRepository repo) {
        this.repo = repo;
    }


    public CourseMethods(CourseRepository repo, UserMethods userMethods) {
        this.repo = repo;
        this.userMethods = userMethods;
    }

    public void addNewCourse(Course course) {
        this.repo.save(course);
    }

    // Called only when 2nd constructor is used
    public List<Course> getCoursesByTopicId(String topicID) {
        List<Course> courses = new ArrayList<>();
        for (Course course : this.repo.findAll()) {
            if (course.getTopicID().equals(topicID)) {
                course.setCourseOwner(this.userMethods.getUserNameByID(course.getUserID()));
                courses.add(course);
            }
        }
        return courses;
    }

    public Course getCourseById(String id) {
        int courseID = Integer.parseInt(id);
        Optional<Course> course = this.repo.findById(courseID);
        return course.get();
    }

    public List<Course> getUserCourses(String userId) {
        List<Course> courses = new ArrayList<>();
        for (Course course : this.repo.findAll()) {
            if (course.getUserID().equals(userId)) {
                courses.add(course);
            }
        }
        return courses;
    }
}
