import java.time.LocalDate;

public class Assignment {

    private String title;
    private String description;
    private LocalDate subDateTime;
    private int totalMark;

    public Assignment() {
    }

    public Assignment(String title, String description, LocalDate subDateTime, int totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.totalMark = totalMark;
    }

    public void printAssignment() {
        System.out.printf("%-25s%-12s%-15s%-15s\n", title, totalMark, subDateTime, description);
    }


    @Override
    public String toString() {
        return "Assignment{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", subDateTime=" + subDateTime +
                ", totalMark=" + totalMark +
                '}' + "\n";
    }

    public void printAssignmentList() {
        System.out.printf("%-25s%-15s%-15s%-15s\n", title, totalMark, subDateTime, description);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.subDateTime = subDateTime;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }
}
