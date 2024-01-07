// Part Done
// -Admin can create students and lecturers.
// -Admin can create courses and assign courses to lecturers. 
// -Users can login and the system can recognize their user type.
// -Students can self-register for courses in new trimesters. 


import java.util.ArrayList;
import java.util.Scanner;

public class CourseManagementSystem {
    // private int id;
    // private String name;

    // public CourseManagementSystem(int id, String name) {
    // this.id = id;
    // this.name = name;
    // }

}

class Course { //Copy and paste it to Course.java
    public String id;
    public String name;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "CourseID: " + id + ", CourseName: " + name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}

class Student { // Can also copy and paste it to Student.java
    public String id;
    public String name;
    public ArrayList<Course> Trimester1;
    public ArrayList<Course> Trimester2;
    public ArrayList<Course> Trimester3;

    public Student(String id, String name,ArrayList<Course> Trimester1, ArrayList<Course> Trimester2, ArrayList<Course> Trimester3) {
        this.id = id;
        this.name = name;
        this.Trimester1 = Trimester1;
        this.Trimester2 = Trimester2;
        this.Trimester3 = Trimester3;
    }

    public String toString() {
        return "StudentID: " + id + ", StudentName: " + name + ", Trimester1: " + Trimester1 + ", Trimester2: " + Trimester2  + ", Trimester3: " + Trimester3;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean contains(String SID) {
        return false;
    }

    public void addCoursesToT1(Course course){
        Trimester1.add(course);
    }
    public void addCoursesToT2(Course course){
        Trimester2.add(course);
    }
    public void addCoursesToT3(Course course){
        Trimester3.add(course);
    }
}

class Lecturer { //Can also copy and paste it to Lecturer.java
    public String id;
    public String name;
    public ArrayList<Course> courses;

    public Lecturer(String id, String name, ArrayList<Course> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public String toString() {
        return "LecturerID: " + id + ", LecturerName: " + name + " , CoursesAssigned: " + courses;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean contains(String LID) {
        return false;
    }

    public void addCourses(Course course){
        courses.add(course);
    }
}

class TestSystem {

    public static void main(String[] args) {

        ArrayList<Course> CourseList = new ArrayList<>();
        ArrayList<Student> StudentList = new ArrayList<>();
        ArrayList<Lecturer> LecturerList = new ArrayList<>();

        int option;
        int profile = 0;
        String course;
        String id;
        String LecID;
        String CourID;
        String StuID;
        String name;
        String confirmation;
        boolean exitProgram = false;

        Scanner sc = new Scanner(System.in);
        StudentList.add(new Student("1211101453", "Lee",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        LecturerList.add(new Lecturer("905488", "Steven",new ArrayList<>()));
        CourseList.add(new Course("C102","OOPDS"));

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
                            do {

                                System.out.println("Select OPTION");
                                System.out.println("1.Add Courses");
                                System.out.println("2.Add Student");
                                System.out.println("3.Add Lecturer");
                                System.out.println("4.Assign Course");
                                System.out.println("5.Logout");
                                System.out.print("Enter your choice (1/2/3/4/5): ");
                                option = sc.nextInt();
                                sc.nextLine(); // Consume the newline
                                switch (option) {
                                    case 1:
                                        do {
                                            System.out.print("Please Enter Course ID: ");
                                            CourID = sc.nextLine();
                                            System.out.print("Please Enter Course Name: ");
                                            name = sc.nextLine();
                                            CourseList.add(new Course(CourID, name));
                                            System.out.println("Successfully added " + CourID + " " + name);
                                            for (Course list : CourseList) {
                                                System.out.println(list.toString());
                                            }
                                            System.out.print("Do you still want to add (Y/N): ");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("Y"));
                                        break;
                                    case 2:
                                        do {
                                            System.out.print("Please Enter Student ID: ");
                                            id = sc.nextLine();
                                            System.out.print("Please Enter Student Name: ");
                                            name = sc.nextLine();
                                            System.out.println(id + " " + name + " has been successfully added");
                                            StudentList.add(new Student(id, name,new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
                                            for (Student list : StudentList) {
                                                System.out.println(list.toString());
                                            }
                                            System.out.print("Do you still want to add (Y/N): ");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("Y"));
                                        break;
                                    case 3:
                                        do {
                                            System.out.print("Please Enter Lecturer ID: ");
                                            LecID = sc.nextLine();
                                            System.out.print("Please Enter Lecturer Name: ");
                                            name = sc.nextLine();
                                            System.out.println(LecID + " " + name + " has been successfully added");
                                            LecturerList.add(new Lecturer(LecID, name,new ArrayList<>()));
                                            for (Lecturer list : LecturerList) {
                                                System.out.println(list.toString());
                                            }
                                            System.out.print("Do you still want to add (Y/N): ");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("Y"));
                                        break;
                                    case 4:
                                        do {
                                            System.out.print("Enter CoursesID: ");
                                            CourID = sc.nextLine();
                                            System.out.print("Enter LecturerID to assign to it: ");
                                            LecID = sc.nextLine();
                                            int Cindex = searchCourseIdIndex(CourseList,CourID);
                                            int Lindex = searchLecturerIdIndex(LecturerList,LecID);
                                            Course Course = CourseList.get(Cindex);
                                            Lecturer Lecturer = LecturerList.get(Lindex);
                                            Lecturer.addCourses(Course);
                                            System.out.println(LecturerList.get(Lindex));
                                            System.out.print("Do you still want to assign (Y/N): ");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("Y"));
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
                                    case 1:
                                        System.out.println("These are the courses you have enrolled for each Trimester");
                                        System.out.println("Trimester I: ");
                                        System.out.println("Trimester II: ");
                                        System.out.println("Trimester III: ");
                                        break;

                                    case 2:
                                        System.out.println("Select trimester you want to enroll");
                                        System.out.println("1. Trimester I: ");
                                        System.out.println("2. Trimester II: ");
                                        System.out.println("3. Trimester III: ");
                                        System.out.println("4. Back");
                                        System.out.print("Enter your choice (1/2/3/4): ");
                                        boolean exitEnrollMenu = false;
                                        do{
                                        option = sc.nextInt();
                                        sc.nextLine(); // consume the newline
                                                                       
                                        switch(option){
                                            case 1:
                                                do {
                                                System.out.print("Enter CoursesID that you want to enroll: ");
                                                CourID = sc.nextLine();
                                                StuID = SID;
                                                int Cindex = searchCourseIdIndex(CourseList,CourID);
                                                int Sindex = searchStudentIdIndex(StudentList,StuID);
                                                Course Course = CourseList.get(Cindex);
                                                Student Student = StudentList.get(Sindex);
                                                Student.addCoursesToT1(Course);
                                                System.out.println(StudentList.get(Sindex));
                                                System.out.print("Do you still want to assign (Y/N): ");
                                                confirmation = sc.nextLine();
                                                } while (confirmation.equalsIgnoreCase("Y"));
                                            break;
                                            case 2:
                                                do {
                                                System.out.print("Enter CoursesID that you want to enroll: ");
                                                CourID = sc.nextLine();
                                                StuID = SID;
                                                int Cindex = searchCourseIdIndex(CourseList,CourID);
                                                int Sindex = searchStudentIdIndex(StudentList,StuID);
                                                Course Course = CourseList.get(Cindex);
                                                Student Student = StudentList.get(Sindex);
                                                Student.addCoursesToT2(Course);
                                                System.out.println(StudentList.get(Sindex));
                                                System.out.print("Do you still want to assign (Y/N): ");
                                                confirmation = sc.nextLine();
                                                } while (confirmation.equalsIgnoreCase("Y"));
                                                
                                            break;
                                            case 3:
                                            do {
                                                System.out.print("Enter CoursesID that you want to enroll: ");
                                                CourID = sc.nextLine();
                                                StuID = SID;
                                                int Cindex = searchCourseIdIndex(CourseList,CourID);
                                                int Sindex = searchStudentIdIndex(StudentList,StuID);
                                                Course Course = CourseList.get(Cindex);
                                                Student Student = StudentList.get(Sindex);
                                                Student.addCoursesToT1(Course);
                                                System.out.println(StudentList.get(Sindex));
                                                System.out.print("Do you still want to assign (Y/N): ");
                                                confirmation = sc.nextLine();
                                                } while (confirmation.equalsIgnoreCase("Y"));
                                            break;
                                            case 4:
                                                exitEnrollMenu = true;
                                            default:
                                                System.out.println("Invalid option, Please Select Again");
                                        }
                                        } while (!exitEnrollMenu);
                                    break;
                                    case 3:
                                        System.out.println("Select your trimester");
                                        System.out.println("Trimester I = 1, Trimester II = 2, Trimester = III");
                                        System.out.println("Please key in course ID");
                                        course = sc.nextLine();
                                        System.out.println("You have dropped out of course: " + course);
                                        break;
                                    case 4:
                                        exitStudentMenu = true;
                                        break;
                                    default:
                                        System.out.println("Invalid option");
                                        break;
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
                                        break;
                                    case 2:
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
                }
            } else {
                System.out.println("Please enter an integer");
                sc.nextLine(); // Consume the invalid input
            }
        } while (!exitProgram);

    }

    // To identify Student
    public static boolean searchStudentID(ArrayList<Student> StudentList, String SID) {
        for (Student StudentID : StudentList) {
            if (StudentID.getId().equals(SID))
                return true;
        }
        return false;
    }

    // To identify Lecturer
    public static boolean searchLecturerID(ArrayList<Lecturer> LecturerList, String LID) {
        for (Lecturer LecturerID : LecturerList) {
            if (LecturerID.getId().equals(LID))
                return true;
        }
        return false;
    }

    // Get CourseID index
    public static int searchCourseIdIndex(ArrayList<Course> CourseList, String CourID) {
    for (int i = 0; i < CourseList.size(); i++) {
        if (CourseList.get(i).getId().equals(CourID)) {
            return i; // Return the index when the course ID is found
        }
    }
    return -1; // Return -1 if the course ID is not found in the list
    }

    // Get LecturerID index
    public static int searchLecturerIdIndex(ArrayList<Lecturer> LecturerList, String LecID) {
    for (int i = 0; i < LecturerList.size(); i++) {
        if (LecturerList.get(i).getId().equals(LecID)) {
            return i; // Return the index when the course ID is found
        }
    }
    return -1; // Return -1 if the lecturer ID is not found in the list
    }

    // Get StudentID index
    public static int searchStudentIdIndex(ArrayList<Student> StudentList, String LecID) {
    for (int i = 0; i < StudentList.size(); i++) {
        if (StudentList.get(i).getId().equals(LecID)) {
            return i; // Return the index when the course ID is found
        }
    }
    return -1; // Return -1 if the student ID is not found in the list
    }
}