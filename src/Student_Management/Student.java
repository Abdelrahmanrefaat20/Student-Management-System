package Student_Management;

import java.util.ArrayList;

public class Student extends Enrollment implements StudentService {
    private String name;
    private int age;
    private String id;
    private ArrayList<Enrollment> enrollments;
    private double gpa;

    public Student(String name, int age, String id) {
        super();
        this.name = name;
        this.age = age;
        this.id = id;
        this.enrollments = new ArrayList<>();
        StudentService.students.add(this);

    }

    public ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(ArrayList<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public double getGpa() {
        if (enrollments.isEmpty()) {
            return 0.0;
        }
        double totalPoints = 0;
        int count = 0;
        for (Enrollment e : enrollments) {
            if (e.getGrade() != null) {
                totalPoints += e.getGrade().getPoint();
                count++;
            }
        }
        if (count == 0) return 0.0;
        return totalPoints / count;
    }

    public void printTranscript() {
        System.out.println("--- Transcript ---");
        for (Enrollment e : enrollments) {
            if (e.getGrade() != null) {
                Grade g = e.getGrade();
                System.out.println(e.getCourse().getCode() + " - " + e.getCourse().getCourseName() + " | Grade: " + g.getGradeScore().intValue() + " | " + g.getGradeLetter() + " | " + g.getPoint());
            }
        }
        System.out.println("GPA: " + String.format("%.2f", getGpa()));
    }


    @Override
    public void addStudent(String name, int age, String id) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                System.out.println("Error: ID already exists");
                return;
            }
        }
        Student newStudent = new Student(name, age, id);
        students.add(newStudent);
        System.out.println("Student added successfully: " + newStudent.getName());
    }

    @Override
    public void removeStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                System.out.println("Student removed");
                return;
            }
        }
        System.out.println("Error: Student not found");
    }

    @Override
    public void getStudents(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)){
                System.out.println("Student found");
                return;
            }
        }
        System.out.println("Error: Student not found");
    }
}
