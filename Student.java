public class Student {
    private String studentName;
    private double studentGrade;
    private String studentLetterGrade;

    public Student(String studentName, double studentGrade) {
        this.studentName = studentName;
        this.studentGrade = studentGrade;
        this.studentLetterGrade = getLetterGrade(studentGrade);
    }
    public Student() {
    }

    public String getStudentName() {
        return studentName;
    }

    public double getStudentGrade() {
        return studentGrade;
    }

    public String getStudentLetterGrade() {
        return studentLetterGrade;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentGrade(double studentGrade) {
        this.studentGrade = studentGrade;
        this.studentLetterGrade = getLetterGrade(studentGrade);
    }

    private String getLetterGrade(double studentGrade) {
        if (studentGrade >= 90) {
            return "A";
        } else if (studentGrade >= 80) {
            return "B";
        } else if (studentGrade >= 70) {
            return "C";
        } else if (studentGrade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}