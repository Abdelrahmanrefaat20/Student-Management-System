package Student_Management;

public interface EnrollmentService {
    public void enroll(Student student , Course course);
    public void addGrade(Student student , Course course , Grade grade);
}
