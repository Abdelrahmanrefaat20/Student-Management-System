package Student_Management;

public class Course extends Enrollment implements CourseService{
    private String code,courseName;
    private int capacity,enrollmentCount;

    public Course(String code, String courseName, int capacity ) {
        this.code = code;
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrollmentCount = 0;
        CourseService.courses.add(this);

    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getEnrollmentCount() {
        return enrollmentCount;
    }

    public void setEnrollmentCount(int enrollmentCount) {
        this.enrollmentCount = enrollmentCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean hasSpace(){
        return enrollmentCount <= capacity;
    }
    public void increaseEnrollmentCount(){
        enrollmentCount++;
    }

    @Override
    public void addCourse(String code, String courseName, int capacity) {
        if (code == null || code.isEmpty()) return; // ← ignore dummy
        for (Course c : courses) {
            if (c.getCode().equals(code)) {
                System.out.println("Error: Course already exists");
                return;
            }
        }
        Course newCourse = new Course(code, courseName, capacity);
        courses.add(newCourse);
        System.out.println("Course added successfully");
    }

    @Override
    public Course getCourse(String courseId) {
        for (Course c : courses) {
            if (c.getCode().equals(courseId)) {
                System.out.println("Course found: " + c.getCourseName());
                return c;
            }
        }
        System.out.println("Error: Course not found");
        return null;
    }
}
