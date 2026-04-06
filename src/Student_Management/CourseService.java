package Student_Management;

import java.util.ArrayList;

public interface CourseService {
     ArrayList<Course> courses= new ArrayList<>();
    public void addCourse(String code, String courseName, int capacity);
    public Course getCourse(String courseId);


}
