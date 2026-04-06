package Student_Management;

import java.util.ArrayList;

public interface StudentService {
    ArrayList<Student> students = new ArrayList<>();
    public void addStudent(String name, int age, String id);
    public void removeStudent(String id);
    public void getStudents(String id);
}
