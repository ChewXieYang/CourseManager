// import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseManagementSystem {
    private int id;
    private String name;

    public CourseManagementSystem(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

class TestSystem {
    public static void main(String[] args) {

        ArrayList<String> CourseList = new ArrayList<>();
        ArrayList<String> StudentList = new ArrayList<>();
        ArrayList<String> LecturerList = new ArrayList<>();

        int profile = 0;
        String course;
        int option;
        String student;
        String lecturer;
        boolean exitProgram = false;
        Scanner sc = new Scanner(System.in);

        StudentList.add("1211101453 Lee");
        LecturerList.add("905477 Steven");

        System.out.println("Welcome to Course Manager");
        do {
            System.out.println("Select your profile:");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Lecturer");
            System.out.println("4. EXIT PROGRAM");
            System.out.print("Enter your choice (1/2/3/4): ");

            if (sc.hasNextInt()) {
                profile = sc.nextInt();
                sc.nextLine();

                switch (profile) {
                    case 1: // ADMIN
                        System.out.print("Please Enter Password: ");
                        String password = sc.nextLine();
                        if (password.equals("12345")) {
                            System.out.println("Welcome, Admin");
                            boolean exitAdminMenu = false;
                            String confirmation;
                            do {

                                System.out.println("Select OPTION");
                                System.out.println("1.Add Courses");
                                System.out.println("2.Add Student");
                                System.out.println("3.Add Lecturer");
                                System.out.println("4.Assign Courses");
                                System.out.println("5.Logout");
                                System.out.print("Enter your choice (1/2/3/4/5): ");
                                option = sc.nextInt();
                                sc.nextLine(); // Consume the newline

                                switch (option) {
                                    case 1:
                                        do {
                                            System.out.println("Please Enter Course ID and Name ");
                                            course = sc.nextLine();
                                            CourseList.add(course);
                                            System.out.println(course + " has been successfully added");
                                            System.out.println("Do you still want to add (yes/no)");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("yes"));
                                        break;
                                    case 2:
                                        do {
                                            System.out.println("Please Enter Student ID and Name ");
                                            student = sc.nextLine();
                                            StudentList.add(student);
                                            System.out.println(student + " has been successfully added");
                                            System.out.println("Do you still want to add (yes/no)");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("yes"));
                                        break;
                                    case 3:
                                        do {
                                            System.out.println("Please Enter Lecturer ID and Name ");
                                            lecturer = sc.nextLine();
                                            LecturerList.add(lecturer);
                                            System.out.println(lecturer + " has been successfully added");
                                            System.out.println("Do you still want to add (yes/no)");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("yes"));
                                        break;
                                    case 4:
                                        do {
                                            // ASSIGN COURSES TO LECTURER
                                            System.out.println("Do you still want to assign (yes/no)");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("yes"));
                                        break;
                                    case 5:
                                        exitAdminMenu = true;
                                        break;
                                    default:
                                        System.out.println("Invalid option, Please Select Again");
                                }
                            } while (!exitAdminMenu);

                        } else
                            System.out.println("Password Incorrect, Access Denied");
                        break;

                    case 2: // STUDENT

                        System.out.print("Please enter you Student ID: ");
                        String SID = sc.nextLine();
                        boolean foundStudent = searchStudentID(StudentList, SID);
                        
                        if (foundStudent) {
                            System.out.println("Welcome, Student " + SID);
                            boolean exitStudentMenu = false;
                            String confirmation;
                            do {

                                System.out.println("Select OPTION");
                                System.out.println("1.View Courses");
                                System.out.println("2.Enroll Courses");
                                System.out.println("3.Drop Courses");
                                System.out.println("4.Logout");
                                System.out.print("Enter your choice (1/2/3/4): ");
                                option = sc.nextInt();
                                sc.nextLine();
                                switch (option) {
                                    case 1://VIEW ENROLLED COURSES
                                        System.out.println("These are the courses you have enrolled for each Trimester");
                                        System.out.println("Trimester I: " + CourseTrimesterI);
                                        System.out.println("Trimester II: "+ CourseTrimesterII);
                                        System.out.println("Trimester III: "+ CourseTrimesterIII);
                                        break;

                                    case 2://ENROLL COURSE
                                        do{
                                        System.out.println("Select your trimester");
                                        System.out.println("Trimester I = 1, Trimester II = 2, Trimester III = 3");
                                        trimester = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Please key in course ID");                                         
                                            switch(trimester){
                                                case 1:
                                                    courseID1 = sc.nextLine();
                                                    CourseTrimesterI.add(courseID1);
                                                    System.out.println("You have enrolled for course: " + courseID1 + " in Trimester " + trimester);
                                                    break;
                                                case 2:
                                                    courseID2 = sc.nextLine();
                                                    CourseTrimesterII.add(courseID2);
                                                    System.out.println("You have enrolled for course: " + courseID2 + " in Trimester " + trimester);
                                                    break;
                                                case 3:
                                                    courseID3 = sc.nextLine();
                                                    CourseTrimesterIII.add(courseID3);
                                                    System.out.println("You have enrolled for course: " + courseID3 + " in Trimester " + trimester);
                                                    break;
                                            }
                                        System.out.println("Would you like to enroll more courses? (yes/no)");
                                        confirmation = sc.nextLine();
                                        }while (confirmation.equalsIgnoreCase("yes"));
                                        break;
                                    case 3://DROPOUT COURSE
                                        do{
                                        System.out.println("Select your trimester");
                                        System.out.println("Trimester I = 1, Trimester II = 2, Trimester III = 3");
                                        trimester = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Please key in course ID");
                                        switch(trimester){
                                                case 1:
                                                    courseID1 = sc.nextLine();
                                                    CourseTrimesterI.remove(courseID1);
                                                    System.out.println("You have dropped course: " + courseID1 + " in Trimester " + trimester);
                                                    break;
                                                case 2:
                                                    courseID2 = sc.nextLine();
                                                    CourseTrimesterII.remove(courseID2);
                                                    System.out.println("You have dropped course: " + courseID2 + " in Trimester " + trimester);
                                                    break;
                                                case 3:
                                                    courseID3 = sc.nextLine();
                                                    CourseTrimesterIII.remove(courseID3);
                                                    System.out.println("You have dropped course: " + courseID3 + " in Trimester " + trimester);
                                                    break;
                                            }
                                        System.out.println("Would you like to drop more courses? (yes/no)");
                                        confirmation = sc.nextLine();
                                        }while (confirmation.equalsIgnoreCase("yes"));
                                        break;
                                    case 4:
                                        exitStudentMenu = true;
                                        break;
                                    default:
                                        System.out.println("Invalid option");
                                    }
                                } while (!exitStudentMenu);
                            } else
                            System.out.println("ID not found, You are not registered as a student");
                        break;

                    case 3: // LECTURER
                        System.out.print("Please enter you Lecturer ID: ");
                        String LID = sc.nextLine();
                        boolean foundLecturer = searchLecturerID(LecturerList, LID);
                        if (foundLecturer) {
                            System.out.println("Welcome Lecturer " + LID);
                            boolean exitLecturerMenu = false;
                            do {

                                System.out.println("Select OPTION");
                                System.out.println("1.View Courses Assigned");
                                System.out.println("2.View Students in Courses");
                                System.out.println("3.Logout");
                                System.out.print("Enter your choice (1/2/3/): ");
                                option = sc.nextInt();

                                sc.nextLine();

                                switch (option) {
                                    case 1:
                                        System.out.println("You have assigned the following class: ");
                                        break;
                                    case 2:
                                        System.out.println("Type the course you want to check: ");
                                        checkCourse = sc.nextLine();
                                        sc.nextLine();
                                        System.out.println("The students in course: ");
                                        break;
                                    case 3:
                                        exitLecturerMenu = true;
                                        break;
                                    default:
                                        System.out.println("Invalid option");
                                }

                            } while (!exitLecturerMenu);
                        } else
                            System.out.println("ID not found, You are not registered as a lecturer");
                        break;
                    case 4:
                        exitProgram = true;
                        break;
                    default:
                        System.out.println("Invalid profile, Please Select Again");
                        break;

                }
            } else {
                System.out.println("Please enter an integer");
                sc.nextLine(); // Consume the invalid input
            }
        } while (!exitProgram);

    }

    // Method to identify Student
    public static boolean searchStudentID(ArrayList<String> StudentList, String SID) {
        for (String StudentID : StudentList) {
            if (StudentID.contains(SID))
                return true;
        }
        return false;
    }

    // Method to identify Lecturer
    public static boolean searchLecturerID(ArrayList<String> LecturerList, String LID) {
        for (String LecturerID : LecturerList) {
            if (LecturerID.contains(LID))
                return true;
        }
        return false;
    }

}
