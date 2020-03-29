import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String title;
    private String stream;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Student> studentsArrayList = new ArrayList<>();
    private List<Trainer> trainersArrayList = new ArrayList<>();
    private List<Assignment> assignmentArrayList = new ArrayList<>();

    public Course() {
    }

    public Course(String title, String stream, String type, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean addStudent(Student student) {
        if (student == null || studentsArrayList.contains(student)) {
            return false;
        }
        studentsArrayList.add(student);
        return true;
    }

    public List<Assignment> getAssignmentArrayList() {
        return assignmentArrayList;
    }

    public void printStudents() {
        for (Student s : studentsArrayList) {
            System.out.printf("%-12s%-12s%-15s%-10s\n", s.getFirstName(), s.getLastName(), s.getDateOfBirth(), s.getTuitionFees());
        }

    }

    public boolean addAssignment(Assignment assignment) {
        if (assignment == null || assignmentArrayList.contains(assignment)) {
            return false;
        }
        assignmentArrayList.add(assignment);
        return true;
    }

    public void printAssignments() {
        for (Assignment a : assignmentArrayList) {
            System.out.printf("%-25s%-12s%-15s%-15s\n", a.getTitle(), a.getTotalMark(), a.getSubDateTime(), a.getDescription());
        }

    }

    public boolean addTrainer(Trainer trainer) {
        if (trainer == null || trainersArrayList.contains(trainer)) {
            return false;
        }
        trainersArrayList.add(trainer);
        return true;
    }

    public void printTrainers() {
        for (Trainer t : trainersArrayList) {
            System.out.printf("%-15s%-15s%-15s\n", t.getFirstName(), t.getLastName(), t.getSubject());
        }

    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                " stream='" + stream + '\'' +
                " type='" + type + '\'' +
                " startDate=" + startDate +
                " endDate=" + endDate +
                '}';
    }

    public void printCourseList() {
        System.out.printf("%-10s%-10s%-10s%-15s%-10s\n", title, stream, type, startDate, endDate);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
