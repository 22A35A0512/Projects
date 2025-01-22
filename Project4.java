import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {
    private String studentId;
    private String name;
    private List<Course> courses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        courses.add(course);
    }

    public void assignGrade(Course course, Grade grade) {
        course.setGrade(this, grade);
    }

    public double calculateGPA() {
        double totalCredits = 0;
        double totalGradePoints = 0;

        for (Course course : courses) {
            Grade grade = course.getGrade(this);
            if (grade != null) {
                double credit = course.getCredit();
                totalCredits += credit;
                totalGradePoints += credit * grade.getGradePoint();
            }
        }

        if (totalCredits == 0) {
            return 0; // To avoid division by zero
        }

        return totalGradePoints / totalCredits;
    }
}

class Course {
    private String courseId;
    private String name;
    private double credit;
    private Map<Student, Grade> gradeMap;

    public Course(String courseId, String name, double credit) {
        this.courseId = courseId;
        this.name = name;
        this.credit = credit;
        this.gradeMap = new HashMap<>();
    }

    public void setGrade(Student student, Grade grade) {
        gradeMap.put(student, grade);
    }

    public Grade getGrade(Student student) {
        return gradeMap.get(student);
    }

    public double getCredit() {
        return credit;
    }
}

class Grade {
    private String grade;
    private double gradePoint;

    public Grade(String grade, double gradePoint) {
        this.grade = grade;
        this.gradePoint = gradePoint;
    }

    public double getGradePoint() {
        return gradePoint;
    }
}

public class Project4 {
    public static void main(String[] args) {
        // Create students
        Student student1 = new Student("S001", "John");
	Student student2 = new Student("S002", "Alice");

	// Create courses
	Course course1 = new Course("C001", "Math", 3.0);
	Course course2 = new Course("C002", "English", 2.0);

	// Enroll students in courses
	student1.enrollCourse(course1);
	student1.enrollCourse(course2);
	student2.enrollCourse(course1);

	// Assign grades to students
	Grade gradeA = new Grade("A", 4.0);
	Grade gradeB = new Grade("B", 3.0);

	student1.assignGrade(course1, gradeA);
	student1.assignGrade(course2, gradeB);
	student2.assignGrade(course1, gradeB);

	// Calculate GPA for students
	double gpa1 = student1.calculateGPA();
	double gpa2 = student2.calculateGPA();

	System.out.println("GPA for student1: " + gpa1);
	System.out.println("GPA for student2: " + gpa2);
    }
}
