//import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class CourseManagementSystem {
    private int id;
    private String name;

    public CourseManagementSystem(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class TestSystem2 {
    public static void main(String[] args) {

        ArrayList<String> CourseList = new ArrayList<>();
        ArrayList<String> StudentList = new ArrayList<>();
        ArrayList<String> LecturerList = new ArrayList<>();
        
        System.out.println("Welcome to Course Manager");
        Scanner sc = new Scanner(System.in);

        int profile = 0;
        String course;
        int option;
        String student;
        String lecturer;

        boolean exitProgram = false;

        do {
            System.out.println("Select your profile:");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Teacher");
            System.out.println("4. EXIT PROGRAM");
            System.out.print("Enter your choice (1/2/3/4): ");

            if (sc.hasNextInt()) {
                profile = sc.nextInt();
                sc.nextLine();

                switch (profile) {
                    case 1:
                        System.out.println("Welcome, Admin");
                        boolean exitAdminMenu = false;
                        String confirmation;
                        do {

                            System.out.println("Select OPTION");
                            System.out.println("1.Add Courses");
                            System.out.println("2.Add Student");
                            System.out.println("3.Add Lecturer");
                            System.out.println("4.Back");
                            System.out.print("Enter your choice (1/2/3/4): ");
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
                                    exitAdminMenu = true;
                                    break;
                                default:
                                    System.out.println("Invalid option, Please Select Again");
                            }
                        } while (!exitAdminMenu);
                        break;
                    case 2:
                        System.out.println("Welcome, Student");
                        boolean exitStudentMenu = false;
                        do {

                            System.out.println("Select OPTION");
                            System.out.println("1.View Courses");
                            System.out.println("2.Enroll Courses");
                            System.out.println("3.Drop Courses");
                            System.out.print("Enter your choice (1/2/3): ");
                            option = sc.nextInt();

                            sc.nextLine();

                            switch (option) {
                                case 1:

                                    System.out.println("These are the courses you have enrolled for each Trimester");
                                    System.out.println("Trimester I: ");
                                    System.out.println("Trimester II: ");
                                    System.out.println("Trimester III: ");
                                    break;

                                case 2:
                                    System.out.println("Select your trimester");
                                    System.out.println("Trimester I = 1, Trimester II = 2, Trimester = III");
                                    System.out.println("Please key in course ID");
                                    course = sc.nextLine();
                                    System.out.println("You have enrolled for course: " + course);
                                    break;
                                case 3:
                                    System.out.println("Select your trimester");
                                    System.out.println("Trimester I = 1, Trimester II = 2, Trimester = III");
                                    System.out.println("Please key in course ID");
                                    course = sc.nextLine();
                                    System.out.println("You have dropped out of course: " + course);
                                    break;
                                default:
                                    System.out.println("Invalid option");
                            }

                            System.out.println("Do you want to go back to Admin menu? (yes/no)");
                            confirmation = sc.nextLine();
                            if (!confirmation.equalsIgnoreCase("yes")) {
                                exitAdminMenu = true;
                            }
                        } while (!exitStudentMenu);
                        break;
                    case 4:
                        exitProgram = true;
                        break;
                    default:
                        System.out.println("Invalid profile, Please Select Again");
                        break;

                }
            }
            else
            {
                System.out.println("Please enter an integer");
                sc.nextLine(); // Consume the invalid input 
            }
        } while (!exitProgram);
        
    }
}
