import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int tuitionFees;
    public List<Course> studentCoursesArrayList = new ArrayList<>();


    public Student() {

    }

    public boolean addCourse(Course course) {
        if (course == null || studentCoursesArrayList.contains(course)) {
            return false;
        }
        studentCoursesArrayList.add(course);
        return true;
    }

    public List getAssignmentsFromCourses() {
        List<Assignment> assignmentsFromCoursesList = new ArrayList<>();
        for (Course course : studentCoursesArrayList) {
            assignmentsFromCoursesList.addAll(course.getAssignmentArrayList());
        }
        return assignmentsFromCoursesList;
    }

    public void printCourse() {
        for (Course c : studentCoursesArrayList) {
            System.out.printf("%-10s%-10s%-10s%-15s%-10s\n", c.getTitle(), c.getStream(), c.getType(), c.getStartDate(), c.getEndDate());
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", tuitionFees=" + tuitionFees;
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, int tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;

    }

    public void printStudentList() {
        System.out.printf("%-15s%-15s%-15s%-15s\n", firstName, lastName, dateOfBirth, tuitionFees);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }
}
