package main.db_methods;

import main.Course;
import main.CourseRepository;

public class CourseMethods {

    private CourseRepository repo;

    public CourseMethods(CourseRepository repo) {
        this.repo = repo;
    }


    public void addNewCourse(Course course) {
        this.repo.save(course);
    }
}
