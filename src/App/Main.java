import Student_Management.*;
void main() {
    Student s1 = new Student("Ahmed Ali", 20, "1");
    Course cs101 = new Course("CS101", "Data Structures", 2);
    Course cs102 = new Course("CS102", "Algorithms", 2);
    System.out.println("Student: [ID: " + s1.getId() + " | Name: " + s1.getName() + "]");
    Enrollment service = new Enrollment();

    service.enroll(s1, cs101);
    service.enroll(s1, cs101);
    service.enroll(s1, cs102);

    service.addGrade(s1, cs101, new Grade("B", 85.0));
    service.addGrade(s1, cs102, new Grade("A", 92.0));

    s1.printTranscript();


    s1.addStudent("Ahmed Ali", 20, "1");

    cs102.addCourse("CS102", "Data Structures", 2);
    cs102.getCourse("CS101");

}
