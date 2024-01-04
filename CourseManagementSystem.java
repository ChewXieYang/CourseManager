//import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class CourseManagementSystem {
    private int id;
    private String name;
    public CourseManagementSystem(int id, String name){
        this.id = id;
        this.name = name;
    }
}

class TestSystem {
    public static void main(String[] args) {

        ArrayList<String> CourseList = new ArrayList<>();
        ArrayList<String> StudentList = new ArrayList<>();
        ArrayList<String> LecturerList = new ArrayList<>();

        System.out.println("Welcome to Course Manager");
        System.out.println("Please Select your Profile: [1=Admin, 2=Student, 3=Teacher] ");
        Scanner sc = new Scanner(System.in);

        int profile = 0;
        while (profile != 1 && profile != 2 && profile != 3) {
            System.out.println("Select your profile:");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Teacher");
            System.out.print("Enter your choice (1/2/3): ");

            if (sc.hasNextInt()) {
                profile = sc.nextInt();

                if (profile == 1) {
                    System.out.println("Welcome, Admin");

                    System.out.println("Select OPTION");
                    System.out.println("1.Add Courses");
                    System.out.println("2.Add Student");
                    System.out.println("3.Add Lecturer");
                    System.out.print("Enter your choice (1/2/3): ");
                    if (sc.hasNextInt()) {
                    int option = sc.nextInt();
                    sc.nextLine();
                    String Proceed;

                        if (option == 1){
                        //OPTION 1 FOR ADDING COURSES
                            System.out.println("Do you want to add courses? Y/N");
                            Proceed = sc.nextLine();
                            if (Proceed.equals("Y")){
                            System.out.println("Please Enter Course ID and Name ");
                            String courses = sc.nextLine();
                            CourseList.add(courses);
                            for (int i = 0 ; i < CourseList.size() ; i++)                            
                            System.out.println(CourseList);
                            }
                        }
                        else if (option == 2){
                        //OPTION 2 FOR ADDING STUDENT
                            System.out.println("Do you want to add student? Y/N");
                            Proceed = sc.nextLine();
                            if (Proceed.equals("Y")){
                                System.out.println("Please Enter Student ID and Name ");
                                String students = sc.nextLine();
                                StudentList.add(students);
                                for (int i = 0 ; i < StudentList.size() ; i++)
                                    System.out.println(StudentList);
                            }
                        }
                        else if (option == 3){
                        // OPTION 3 FOR ADDING LECTURER
                            System.out.println("Do you want to add Lecturer? Y/N");
                            Proceed = sc.nextLine();
                            if (Proceed.equals("Y")) {
                                System.out.println("Please Enter Lecturer ID and Name ");
                                String lecturers = sc.nextLine();
                                LecturerList.add(lecturers);
                                for (int i = 0; i < LecturerList.size(); i++)
                                    System.out.println(LecturerList);
                            }
                        }
                    }
                }

                else if (profile == 2) {
                    System.out.println("Welcome, Student");
                    // Student-specific functionalities here
                } else if (profile == 3) {
                    System.out.println("Welcome, Teacher");
                    // Teacher-specific functionalities here
                } else {
                    System.out.println("Please input numbers 1, 2, or 3");
                }
            } else {
                System.out.println("Please enter a valid number");
                sc.next(); // Clear the invalid input
            }
        }
    }
}
