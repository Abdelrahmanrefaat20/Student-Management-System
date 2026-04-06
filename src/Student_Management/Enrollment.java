package Student_Management;


public class Enrollment implements EnrollmentService {
    Student student;
    Course course;
    private Grade grade;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Enrollment(Student student, Course course, Grade grade) {

        this.student = student;
        this.course = course;
        this.grade = grade;
    }

    public Enrollment() {

    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public void enroll(Student student, Course course) {
        for (Enrollment e : student.getEnrollments()) {
            if (e.course.getCourseName().equals(course.getCourseName())) {
                System.out.println("Error: Already enrolled Student: " + student.getId());
                return;
            }
        }
        if (course.getEnrollmentCount() >= course.getCapacity()) {
            System.out.println("Course has reached its maximum capacity");
            return;
        }
        Enrollment e = new Enrollment(student, course, null);
        student.addEnrollment(e);
        course.increaseEnrollmentCount();

//        System.out.println("Enroll in "+course.getCourseName()+" ("+course.getCode()+" )" +" Successfully enrolled Student: "+ student.getId());
        System.out.println("Enroll in " + course.getCode() + " (" + course.getCourseName() + ") → Success");

    }


    @Override
    public void addGrade(Student student, Course course, Grade grade) {
        for (Enrollment e : student.getEnrollments()) {
            if (e.getCourse().getCode().equals(course.getCode())) {
                double score = grade.getGradeScore();
                if (score < 0 || score > 100) {
                    System.out.println("Error: Grade must be between 0 and 100");
                    return;
                }
                e.setGrade(grade);
                System.out.println("Add Grade: " + course.getCode() + " → " + (int) score + " → " + grade.getGradeLetter() + " (" + grade.getPoint() + ")");
                return;
            }
        }
        System.out.println("Error: Student not enrolled in this course");
    }
}
