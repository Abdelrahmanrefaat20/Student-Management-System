package Student_Management;
public class Grade {
    private String GradeLetter;
    private Double GradeScore;

    public Grade(String gradeLetter, Double gradeScore) {
        GradeLetter = gradeLetter;
        GradeScore = gradeScore;
    }

    public String getGradeLetter() {
        return GradeLetter;
    }

    public void setGradeLetter(String gradeLetter) {
        GradeLetter = gradeLetter;
    }

    public Double getGradeScore() {
        return GradeScore;
    }

    public void setGradeScore(Double gradeScore) {
        if (gradeScore < 0 || gradeScore > 100) {
            System.out.println("Error: Grade must be between 0 and 100");
            return;
        }
        this.GradeScore = gradeScore;
        if (gradeScore >= 90) {
            GradeLetter = "A";
        } else if (gradeScore >= 80) {
            GradeLetter = "B";
        } else if (gradeScore >= 70) {
            GradeLetter = "C";
        } else if (gradeScore >= 60) {
            GradeLetter = "D";
        } else {
            GradeLetter = "F";
        }
    }
    public double getPoint() {

        if (GradeLetter.equals("A")) {
            return 4.0;
        }
        else if (GradeLetter.equals("B")) {
            return 3.0;
        }
        else if (GradeLetter.equals("C")) {
            return 2.0;
        }
        else if (GradeLetter.equals("D")) {
            return 1.0;
        }
        else {
            return 0.0;
        }
    }
}
