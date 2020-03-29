import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IndividualProject {

    public static void main(String[] args) {

        firstMethod();

    }

    public static int welcomeMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("  Welcome to the College ");
        System.out.println("--------------------------");
        System.out.println("Would you like to insert data Manually or use Defaults? (M / D)");
        String choice = scanner.next();
        while (!("M".equalsIgnoreCase(choice) || "D".equalsIgnoreCase(choice))) {
            System.out.println("Incorrect.Try again!");
            choice = scanner.next();
        }
        if (choice.equals("M") || choice.equals("m")) {
            choice = "Manually";
            System.out.printf("Your choice: %s\n", choice);
            System.out.println();
            return 1;

        } else {
            choice = "Defaults";
            System.out.printf("Your choice: %s\n", choice);
            System.out.println();
            return 2;
        }
    }

    public static void firstMethod() {

        ArrayList<Course> courseArrayList = new ArrayList<>();
        ArrayList<Student> studentArrayList = new ArrayList<>();
        ArrayList<Assignment> assignmentArrayList = new ArrayList<>();
        ArrayList<Trainer> trainerArrayList = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Course Java = new Course("CB8", "Java", "Full-Time", LocalDate.parse(("01/03/2020"), formatter), LocalDate.parse(("01/06/2020"), formatter));
        Course Sharp = new Course("CB9", "CSharp", "Part-Time", LocalDate.parse(("02/06/2020"), formatter), LocalDate.parse(("02/09/2020"), formatter));
        Course Bull = new Course("CB10", "SQL", "Online", LocalDate.parse(("03/09/2020"), formatter), LocalDate.parse(("03/12/2020"), formatter));

        Student s1 = new Student("Harper", "Jackson", LocalDate.parse(("06/06/1991"), formatter), 15000);
        Student s2 = new Student("Evelyn", "Mason", LocalDate.parse(("02/08/1991"), formatter), 12000);
        Student s3 = new Student("Scarlett", "Carter", LocalDate.parse(("06/12/1993"), formatter), 10000);

        Trainer t1 = new Trainer("Lillian", "Addison", "Java Basics");
        Trainer t2 = new Trainer("Lucy", "Lincoln", "COBOL Basics");
        Trainer t3 = new Trainer("Christian", "Hunter", "C# Basics");

        Assignment a1 = new Assignment("Java Basics", "Basics", LocalDate.parse(("30/03/2020"), formatter), 100);
        Assignment a2 = new Assignment("Java Advanced", "Advanced", LocalDate.parse(("30/04/2020"), formatter), 100);
        Assignment a3 = new Assignment("Java High End", "High End", LocalDate.parse(("29/05/2020"), formatter), 100);

        Assignment a4 = new Assignment("C# Basics", "Basics", LocalDate.parse(("30/06/2020"), formatter), 100);
        Assignment a5 = new Assignment("C# Advanced", "Advanced", LocalDate.parse(("30/07/2020"), formatter), 100);
        Assignment a6 = new Assignment("C# High End", "High End", LocalDate.parse(("28/08/2020"), formatter), 100);

        Assignment a7 = new Assignment("COBOL Basics", "Basics", LocalDate.parse(("30/09/2020"), formatter), 100);
        Assignment a8 = new Assignment("COBOL Advanced", "Advanced", LocalDate.parse(("30/10/2020"), formatter), 100);
        Assignment a9 = new Assignment("COBOL High End", "High End", LocalDate.parse(("30/11/2020"), formatter), 100);

        courseArrayList.add(Java);
        courseArrayList.add(Sharp);
        courseArrayList.add(Bull);
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        trainerArrayList.add(t1);
        trainerArrayList.add(t2);
        trainerArrayList.add(t3);
        assignmentArrayList.add(a1);
        assignmentArrayList.add(a2);
        assignmentArrayList.add(a3);
        assignmentArrayList.add(a4);
        assignmentArrayList.add(a5);
        assignmentArrayList.add(a6);
        assignmentArrayList.add(a7);
        assignmentArrayList.add(a8);
        assignmentArrayList.add(a9);

        int manualOrDefault = welcomeMethod();
        if (manualOrDefault == 1) {
            insertMenu();
        } else {
            matchingMenu(courseArrayList, studentArrayList, assignmentArrayList, trainerArrayList);
        }
    }

    public static void insertMenu() {
        Scanner scanner = new Scanner(System.in);
        String quit = "Exit";
        String option;

        ArrayList<Course> courseArrayList = new ArrayList<>();
        ArrayList<Student> studentArrayList = new ArrayList<>();
        ArrayList<Assignment> assignmentArrayList = new ArrayList<>();
        ArrayList<Trainer> trainerArrayList = new ArrayList<>();

        while (true) {
            System.out.println("--------------------------");
            System.out.println("       Insert Menu ");
            System.out.println("--------------------------");
            System.out.println("1. Insert Course");
            System.out.println("2. Insert Student");
            System.out.println("3. Insert Trainer");
            System.out.println("4. Insert Assignment");
            System.out.println("5. Matching Menu");
            int choice;
            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number!");
                    scanner.next();
                }
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 5);
            switch (choice) {
                case 1:
                    courseArrayList.add(createCourse(new Course()));
                    break;
                case 2:
                    studentArrayList.add(createStudent(new Student()));
                    break;
                case 3:
                    trainerArrayList.add(createTrainer(new Trainer()));
                    break;
                case 4:
                    assignmentArrayList.add(createAssignment(new Assignment()));
                    break;
                case 5:
                    if (courseArrayList.isEmpty()) {
                        System.out.println("Course list is empty!Cant proceed to Matching Menu..");
                        System.out.println();
                    } else if (studentArrayList.isEmpty()) {
                        System.out.println("Student list is empty!Cant proceed to Matching Menu..");
                        System.out.println();
                    } else if (trainerArrayList.isEmpty()) {
                        System.out.println("Trainer list is empty!Cant proceed to Matching Menu..");
                        System.out.println();
                    } else if (assignmentArrayList.isEmpty()) {
                        System.out.println("Assignment list is empty!Cant proceed to Matching Menu..");
                        System.out.println();
                    } else {
                        matchingMenu(courseArrayList, studentArrayList, assignmentArrayList, trainerArrayList);
                    }
                    break;
                default:
                    break;
            }
            System.out.println("Press anything to return to Insert Menu or type \"Exit\" to exit..");
            option = scanner.next();
            if (quit.equalsIgnoreCase(option)) {
                break;
            }
        }
    }

    public static Course createCourse(Course course) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("Please enter course's title:");
        String title = scanner.nextLine();
        while (!title.matches("[a-zA-Z0-9]+") && title.contains(" ")) {
            System.out.println("Please enter a valid title!");
            title = scanner.nextLine();
        }
        course.setTitle(title);
        System.out.println("Please enter course's stream:");
        String stream = scanner.nextLine();
        while (!stream.matches("[a-zA-Z]+") && stream.contains(" ")) {
            System.out.println("Please enter a valid stream!");
            stream = scanner.nextLine();
        }
        course.setStream(stream);
        System.out.println("Please enter type of the course (e.g. Full-time):");
        String type = scanner.nextLine();
        while (!type.matches("[a-zA-Z-]+") || type.contains(" ")) {
            System.out.println("Please enter a valid type!");
            type = scanner.nextLine();
        }
        course.setType(type);
        System.out.println("Please enter the start date of the course:");
        boolean success = false;
        String startDate;
        LocalDate dateFromStringStart = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (!success) {
            try {
                startDate = scanner.next();
                dateFromStringStart = LocalDate.parse(startDate, formatter);
                success = true;
            } catch (DateTimeParseException ex) {
                System.out.println("Please insert date in valid format! (dd/MM/yyyy)");
            }
        }
        course.setStartDate(dateFromStringStart);
        System.out.println("Please enter the end date of the course:");
        success = false;
        String endDate;
        LocalDate dateFromStringEnd = null;
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (!success) {
            try {
                endDate = scanner.next();
                dateFromStringEnd = LocalDate.parse(endDate, formatter);
                while (dateFromStringEnd.isBefore(dateFromStringStart)) {
                    System.out.println("End date can't be before Start date! Please enter a valid date!");
                    endDate = scanner.next();
                    dateFromStringEnd = LocalDate.parse(endDate, formatter);
                }
                success = true;
            } catch (DateTimeParseException ex) {
                System.out.println("Please insert date in valid format! (dd/MM/yyyy)");
            }
        }
        course.setEndDate(dateFromStringEnd);
        System.out.println("--------------------------------");
        System.out.println("Course was successfully created!");
        System.out.println();
        return course;
    }

    public static Student createStudent(Student student) {
        Scanner scanner = new Scanner(System.in);
        int tuitionFees;
        System.out.println("----------------------------------");
        System.out.println("Please enter student's first name:");
        String firstName = scanner.nextLine();
        while (!firstName.matches("[a-zA-Z]+") || firstName.contains(" ")) {
            System.out.println("Please enter a valid first name!");
            firstName = scanner.nextLine();
        }
        student.setFirstName(firstName);
        System.out.println("Please enter student's last name:");
        String lastName = scanner.nextLine();
        while (!lastName.matches("[a-zA-Z]+") || lastName.contains(" ")) {
            System.out.println("Please enter a valid last name!");
            lastName = scanner.nextLine();
        }
        student.setLastName(lastName);
        System.out.println("Please enter student's birth date:");
        boolean success = false;
        String birthDate;
        LocalDate dateFromStringBirth = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (!success) {
            try {
                birthDate = scanner.next();
                dateFromStringBirth = LocalDate.parse(birthDate, formatter);
                success = true;
            } catch (DateTimeParseException ex) {
                System.out.println("Please insert date in valid format! (dd/MM/yyyy)");
            }
        }
        student.setDateOfBirth(dateFromStringBirth);
        do {
            System.out.println("Please enter tuition fees of " + firstName + ":");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number!");
                scanner.next();
            }
            tuitionFees = scanner.nextInt();
        } while (tuitionFees < 0);
        student.setTuitionFees(tuitionFees);
        System.out.println("----------------------------------");
        System.out.println("Student was successfully created!");
        return student;
    }

    public static Trainer createTrainer(Trainer trainer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.println("Please enter trainer's first name:");
        String firstName = scanner.nextLine();
        while (!firstName.matches("[a-zA-Z]+") || firstName.contains(" ")) {
            System.out.println("Please enter a valid first name!");
            firstName = scanner.nextLine();
        }
        trainer.setFirstName(firstName);
        System.out.println("Please enter trainer's last name:");
        String lastName = scanner.nextLine();
        while (!lastName.matches("[a-zA-Z]+") || lastName.contains(" ")) {
            System.out.println("Please enter a valid last name!");
            lastName = scanner.nextLine();
        }
        trainer.setLastName(lastName);
        System.out.println("Please enter the subject of Mr/Mrs " + lastName + ":");
        String subject = scanner.nextLine();
        trainer.setSubject(subject);
        System.out.println("----------------------------------");
        System.out.println("Trainer was successfully created!");
        return trainer;
    }

    public static Assignment createAssignment(Assignment assignment) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------");
        System.out.println("Please enter the assignment's title:");
        String title = scanner.nextLine();
        assignment.setTitle(title);
        System.out.println("Please enter the assignment's description:");
        String description = scanner.nextLine();
        assignment.setDescription(description);
        System.out.println("Please enter the submission date of the assignment:");
        boolean success = false;
        String subDate;
        LocalDate dateFromStringSub = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (!success) {
            try {
                subDate = scanner.next();
                dateFromStringSub = LocalDate.parse(subDate, formatter);
                DayOfWeek dayOfWeek = dateFromStringSub.getDayOfWeek();
                while ((dateFromStringSub.getDayOfWeek() == dayOfWeek.SATURDAY) || (dateFromStringSub.getDayOfWeek() == dayOfWeek.SUNDAY)) {
                    if (dateFromStringSub.getDayOfWeek() == dayOfWeek.SATURDAY) {
                        System.out.println("Submission date is Saturday! Please enter a valid date!");
                    } else {
                        System.out.println("Submission date is Sunday! Please enter a valid date!");
                    }
                    subDate = scanner.next();
                    dateFromStringSub = LocalDate.parse(subDate, formatter);
                }
                success = true;
            } catch (DateTimeParseException ex) {
                System.out.println("Please insert date in valid format! (dd/MM/yyyy)");
            }
        }
        assignment.setSubDateTime(dateFromStringSub);
        int totalMark;
        boolean firstTime = true;
        do {
            if (firstTime) {
                System.out.println("Please enter " + title + "'s total mark:");
                firstTime = false;
            } else {
                System.out.println("Invalid Total Mark value! (1-100)");
            }
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number!");
                scanner.next();
            }
            totalMark = scanner.nextInt();
        } while (totalMark < 0 || totalMark > 100);
        assignment.setTotalMark(totalMark);
        System.out.println("------------------------------------");
        System.out.println("Assignment was successfully created");
        return assignment;
    }

    public static void matchingMenu(ArrayList courseArrayList, ArrayList studentArrayList, ArrayList assignmentArrayList, ArrayList trainerArrayList) {

        boolean studentsToCourses = false;
        boolean trainersToCourses = false;
        boolean assignmentsToCourses = false;

        Scanner scanner = new Scanner(System.in);
        String quit = "Exit";
        int choice;
        String option;
        while (true) {
            System.out.println("--------------------------");
            System.out.println("       Matching Menu ");
            System.out.println("--------------------------");
            System.out.println("1. Add Students to Courses");
            System.out.println("2. Add Trainers to Courses");
            System.out.println("3. Add Assignments to courses ");
            System.out.println("4. Printing Menu");
            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number!");
                    scanner.next();
                }
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 4);
            String stringChoice;
            switch (choice) {
                case 1:
                    studentsToCourses = true;
                    for (int i = 0; i < ((ArrayList<Course>) courseArrayList).size(); i++) {
                        for (int j = 0; j < ((ArrayList<Student>) studentArrayList).size(); j++) {
                            System.out.println("Do u want to add " + ((ArrayList<Student>) studentArrayList).get(j).getFirstName() + " to the course " + ((ArrayList<Course>) courseArrayList).get(i).getTitle() + " ? (Y/N)");
                            stringChoice = scanner.next();
                            while (!("Y".equalsIgnoreCase(stringChoice) || "N".equalsIgnoreCase(stringChoice))) {
                                System.out.println("Incorrect.Try again!");
                                stringChoice = scanner.next();
                            }
                            if (stringChoice.equals("Y") || stringChoice.equals("y")) {
                                ((ArrayList<Course>) courseArrayList).get(i).addStudent(((ArrayList<Student>) studentArrayList).get(j));
                                ((ArrayList<Student>) studentArrayList).get(j).addCourse(((ArrayList<Course>) courseArrayList).get(i));
                            }
                        }
                    }
                    break;
                case 2:
                    trainersToCourses = true;
                    for (int i = 0; i < ((ArrayList<Course>) courseArrayList).size(); i++) {
                        for (int j = 0; j < ((ArrayList<Trainer>) trainerArrayList).size(); j++) {
                            System.out.println("Do u want to add " + ((ArrayList<Trainer>) trainerArrayList).get(j).getFirstName() + " to the course " + ((ArrayList<Course>) courseArrayList).get(i).getTitle() + " ? (Y/N)");
                            stringChoice = scanner.next();
                            while (!("Y".equalsIgnoreCase(stringChoice) || "N".equalsIgnoreCase(stringChoice))) {
                                System.out.println("Incorrect.Try again!");
                                stringChoice = scanner.next();
                            }
                            if (stringChoice.equals("Y") || stringChoice.equals("y")) {
                                ((ArrayList<Course>) courseArrayList).get(i).addTrainer(((ArrayList<Trainer>) trainerArrayList).get(j));
                            }
                        }
                    }
                    break;
                case 3:
                    assignmentsToCourses = true;
                    for (int i = 0; i < ((ArrayList<Course>) courseArrayList).size(); i++) {
                        for (int j = 0; j < ((ArrayList<Assignment>) assignmentArrayList).size(); j++) {
                            if (((ArrayList<Assignment>) assignmentArrayList).get(j).getSubDateTime().isAfter(((ArrayList<Course>) courseArrayList).get(i).getStartDate()) &&
                                    ((ArrayList<Assignment>) assignmentArrayList).get(j).getSubDateTime().isBefore(((ArrayList<Course>) courseArrayList).get(i).getEndDate())) {
                                System.out.println("Do u want to add " + ((ArrayList<Assignment>) assignmentArrayList).get(j).getTitle() + " to the course " + ((ArrayList<Course>) courseArrayList).get(i).getTitle() + " ? (Y/N)");
                                stringChoice = scanner.next();
                                while (!("Y".equalsIgnoreCase(stringChoice) || "N".equalsIgnoreCase(stringChoice))) {
                                    System.out.println("Incorrect.Try again!");
                                    stringChoice = scanner.next();
                                }
                                if (stringChoice.equals("Y") || stringChoice.equals("y")) {
                                    ((ArrayList<Course>) courseArrayList).get(i).addAssignment(((ArrayList<Assignment>) assignmentArrayList).get(j));
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    if (!studentsToCourses || !assignmentsToCourses || !trainersToCourses) {
                        System.out.println("WARNING!!!");
                    }
                    String message = "Are you sure you want to proceed? (Y/N)";
                    if (!studentsToCourses) {
                        System.out.println("-------------------------------------------");
                        System.out.println("Students and courses aren't matched!\nThis will affect specific printing options!");
                        System.out.println("-------------------------------------------");
                        System.out.println(message);
                        stringChoice = scanner.next();
                        while (!("Y".equalsIgnoreCase(stringChoice) || "N".equalsIgnoreCase(stringChoice))) {
                            System.out.println("Incorrect.Try again!");
                            stringChoice = scanner.next();
                        }
                        if (stringChoice.equals("Y") || stringChoice.equals("y")) {
                            printingMenu(courseArrayList, studentArrayList, assignmentArrayList, trainerArrayList);
                        }
                    } else if (!trainersToCourses) {
                        System.out.println("-------------------------------------------");
                        System.out.println("Trainers and courses aren't matched!\nThis will affect specific printing options!");
                        System.out.println("-------------------------------------------");
                        System.out.println(message);
                        stringChoice = scanner.next();
                        while (!("Y".equalsIgnoreCase(stringChoice) || "N".equalsIgnoreCase(stringChoice))) {
                            System.out.println("Incorrect.Try again!");
                            stringChoice = scanner.next();
                        }
                        if (stringChoice.equals("Y") || stringChoice.equals("y")) {
                            printingMenu(courseArrayList, studentArrayList, assignmentArrayList, trainerArrayList);
                        }
                    } else if (!assignmentsToCourses) {
                        System.out.println("-------------------------------------------");
                        System.out.println("Assignments and courses aren't matched!\nThis will affect specific printing options!");
                        System.out.println("-------------------------------------------");
                        System.out.println(message);
                        stringChoice = scanner.next();
                        while (!("Y".equalsIgnoreCase(stringChoice) || "N".equalsIgnoreCase(stringChoice))) {
                            System.out.println("Incorrect.Try again!");
                            stringChoice = scanner.next();
                        }
                        if (stringChoice.equals("Y") || stringChoice.equals("y")) {
                            printingMenu(courseArrayList, studentArrayList, assignmentArrayList, trainerArrayList);
                        }
                    } else {
                        printingMenu(courseArrayList, studentArrayList, assignmentArrayList, trainerArrayList);
                    }
                    break;
                default:
                    break;
            }
            System.out.println("Press any key to return to Matching Menu or type \"Exit\" to exit..");
            option = scanner.next();
            if (quit.equalsIgnoreCase(option)) {
                System.exit(0);
            }
        }
    }

    public static void printingMenu(ArrayList courseArrayList, ArrayList studentArrayList, ArrayList assignmentArrayList, ArrayList trainerArrayList) {

        ArrayList<Course> courseArrayList1 = courseArrayList;
        ArrayList<Student> studentArrayList1 = studentArrayList;
        ArrayList<Trainer> trainerArrayList1 = trainerArrayList;
        ArrayList<Assignment> assignmentArrayList1 = assignmentArrayList;

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String quit = "Exit";
        int choice = 0;
        String option;
        while (true) {
            System.out.println("--------------------------");
            System.out.println("       Printing Menu ");
            System.out.println("--------------------------");
            System.out.println("1. Print Courses");
            System.out.println("2. Print Trainers");
            System.out.println("3. Print Students");
            System.out.println("4. Print Assignments");
            System.out.println("5. Print Students per Course");
            System.out.println("6. Print Trainers per Course");
            System.out.println("7. Print Assignments per Course");
            System.out.println("8. Print Assignments per student");
            System.out.println("9. Print Students signed to multiple Courses");
            System.out.println("10.Check Assignment's Submission date!");
            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number!");
                    scanner.next();
                }
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 10);
            switch (choice) {
                case 1:
                    System.out.println("-----------------");
                    System.out.println("List of Courses:");
                    System.out.println("-----------------");
                    System.out.printf("%-10s%-10s%-10s%-15s%-10s\n", "Title", "Stream", "Type", "Start Date", "End Date");
                    for (Course course : courseArrayList1) {
                        course.printCourseList();
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("-----------------");
                    System.out.println("List of Trainers:");
                    System.out.println("-----------------");
                    System.out.printf("%-15s%-15s%-15s\n", "First Name", "Last Name", "Subject");
                    for (Trainer trainer : trainerArrayList1) {
                        trainer.printTrainerList();
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("-----------------");
                    System.out.println("List of Students:");
                    System.out.println("-----------------");
                    System.out.printf("%-15s%-15s%-15s%-15s\n", "First Name", "Last Name", "Date of Birth", "Tuition Fees");
                    for (Student student : studentArrayList1) {
                        student.printStudentList();
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("-------------------");
                    System.out.println("List of Assignments:");
                    System.out.println("-------------------");
                    System.out.printf("%-25s%-15s%-15s%-15s\n", "Title", "Total Mark", "Sub DateTime", "Description");
                    for (Assignment assignment : assignmentArrayList1) {
                        assignment.printAssignmentList();
                    }
                    System.out.println();
                    break;
                case 5:
                    for (int i = 0; i < courseArrayList1.size(); i++) {
                        System.out.println();
                        System.out.println("---------------------");
                        System.out.println("Course " + courseArrayList1.get(i).getTitle() + " students:");
                        System.out.println("---------------------");
                        System.out.printf("%-12s%-12s%-15s%-10s\n", "First Name", "Last Name", "Date of Birth", "Tuition Fees");
                        courseArrayList1.get(i).printStudents();
                        System.out.println();
                    }
                    break;
                case 6:
                    for (int i = 0; i < courseArrayList1.size(); i++) {
                        System.out.println();
                        System.out.println("---------------------");
                        System.out.println("Course " + courseArrayList1.get(i).getTitle() + " trainers:");
                        System.out.println("---------------------");
                        System.out.printf("%-15s%-15s%-15s\n", "First Name", "Last Name", "Subject");
                        courseArrayList1.get(i).printTrainers();
                    }
                    break;
                case 7:
                    for (int i = 0; i < courseArrayList1.size(); i++) {
                        System.out.println();
                        System.out.println("-----------------------");
                        System.out.println("Course " + courseArrayList1.get(i).getTitle() + " assignments:");
                        System.out.println("-----------------------");
                        System.out.printf("%-25s%-12s%-15s%-15s\n", "Title", "Total Mark", "Sub DateTime", "Description");
                        courseArrayList1.get(i).printAssignments();
                    }
                    break;
                case 8:
                    for (Student student : studentArrayList1) {
                        List<Assignment> assignmentsToStudentList;
                        System.out.println("-------------------------------");
                        System.out.println("Assignments for student: " + student.getFirstName());
                        System.out.println("-------------------------------");
                        System.out.printf("%-25s%-12s%-15s%-15s\n", "Title", "Total Mark", "Sub DateTime", "Description");
                        assignmentsToStudentList = student.getAssignmentsFromCourses();
                        for (Assignment assignment : assignmentsToStudentList) {
                            assignment.printAssignment();
                        }
                    }
                    break;
                case 9:
                    boolean exist = false;
                    for (Student student : studentArrayList1) {
                        if (student.studentCoursesArrayList.size() > 1) {
                            System.out.println("-----------------------");
                            System.out.println("Student " + student.getFirstName() + " courses: ");
                            System.out.println("-----------------------");
                            System.out.printf("%-10s%-10s%-10s%-15s%-10s\n", "Title", "Stream", "Type", "Start Date", "End Date");
                            student.printCourse();
                            exist = true;
                        }
                    }
                    if (!exist) {
                        System.out.println("---------------------------------------------------");
                        System.out.println("None of the students is signed to multiple courses!");
                        System.out.println("---------------------------------------------------");
                    }
                    break;
                case 10:
                    System.out.println("What is the date you want to check?");
                    boolean success = false;
                    String checkDate;
                    LocalDate dateFromStringCheck = null;
                    while (!success) {
                        try {
                            checkDate = scanner.next();
                            dateFromStringCheck = LocalDate.parse(checkDate, formatter);
                            success = true;
                        } catch (DateTimeParseException ex) {
                            System.out.println("Please insert date in valid format! (dd/MM/yyyy)");
                        }
                    }
                    LocalDate firstDateOfWeek = dateFromStringCheck;
                    DayOfWeek dayOfWeek = firstDateOfWeek.getDayOfWeek();
                    while (firstDateOfWeek.getDayOfWeek() != dayOfWeek.MONDAY) {
                        firstDateOfWeek = firstDateOfWeek.minusDays(1);
                    }
                    LocalDate lastDateOfWeek = firstDateOfWeek.plusDays(4);
                    boolean areThereStudents = false;
                    System.out.println("----------------------------------------------------");
                    System.out.println("Students that have at least 1 assignment to deliver");
                    System.out.println("between " + firstDateOfWeek + " and " + lastDateOfWeek + " are:");
                    System.out.println("----------------------------------------------------");
                    for (Student student : studentArrayList1) {
                        List<Assignment> blahList;
                        boolean printOnce = true;
                        blahList = student.getAssignmentsFromCourses();
                        for (int i = 0; i < blahList.size(); i++) {
                            if ((blahList.get(i).getSubDateTime().isBefore(lastDateOfWeek) && blahList.get(i).getSubDateTime().isAfter(firstDateOfWeek)) ||
                                    (blahList.get(i).getSubDateTime()).compareTo(lastDateOfWeek) == 0 || (blahList.get(i).getSubDateTime()).compareTo(firstDateOfWeek) == 0) {

                                areThereStudents = true;
                                if (printOnce) {
                                    System.out.println(student.getFirstName() + " " + student.getLastName());
                                    printOnce = false;
                                }
                            }
                        }
                    }
                    if (!areThereStudents) {
                        System.out.println();
                        System.out.println("There are no students that need to deliver assignments!");
                        System.out.println();
                    }
                    System.out.println();
                    break;
                default:
                    break;
            }
            System.out.println("Press any key to return to Printing Menu or type \"Exit\" to exit..");
            option = scanner.next();
            if (quit.equalsIgnoreCase(option)) {
                System.exit(0);
            }
        }
    }
}
