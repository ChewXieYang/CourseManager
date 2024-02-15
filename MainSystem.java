// Part Done
// -Admin can create students and lecturers.
// -Admin can create courses and assign courses to lecturers. 
// -Users can login and the system can recognize their user type.
// -Students can self-register for courses in new trimesters. 
// -Admin can view all the students and lecturers for courses.


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Serializable;

public class MainSystem {
    private int id;
    private String name;
    private List<Course> CourseList; 
    private List<Student> StudentList; 
    private List<Lecturer> LecturerList; 
    private List<StudentInCourse> StudentInCourse; 
    private List<LecturerSubset> subLecturerList; 
    private List<StudentSubset> subStudentList; 

    public MainSystem(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Course implements Serializable{ //Copy and paste it to Course.java
    public String id;
    public String name;
    private List<Course> prerequisites;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
        this.prerequisites = new ArrayList<>();
    }

    public Course(String id, String name, List<Course> prerequisites) {
        this(id, name);
        this.prerequisites = prerequisites;
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

    public List<Course> getPrerequisites() {
        return prerequisites;
    }
}

class Student implements Serializable{ // Can also copy and paste it to Student.java
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

    public boolean hasCompleted(Course course) {
        // Implement your logic to check if the student has completed the course
        // For simplicity, assume the student has completed the course if it's in Trimester1
        return Trimester1.contains(course);
    }
}

class StudentSubset implements Serializable{
    public String id;
    public String name;

    public StudentSubset(String id, String name) {
        this.id = id;
        this.name = name;
    }
   
    public String toString() {
        return "Student: " + id + "_" + name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

class Lecturer implements Serializable{ //Can also copy and paste it to Lecturer.java
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

    public boolean contains(String LecID) {
        return false;
    }

    public void addCourses(Course course){
        courses.add(course);
    }
}

class LecturerSubset implements Serializable{
    public String id;
    public String name;

    public LecturerSubset(String id, String name) {
        this.id = id;
        this.name = name;
    }
   
    public String toString() {
        return "Lecturer: " + id + "_" + name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}


class StudentInCourse implements Serializable{
    String CourseID;
    String CourseName;
    public ArrayList<LecturerSubset> lecturers;
    public ArrayList<StudentSubset> students;

    public void saveToFile(String filePath) {
        FilePersistence.writeToFile(this, filePath);
    }

    public static StudentInCourse loadFromFile(String filePath) {
        return (StudentInCourse) FilePersistence.readFromFile(filePath);
    }

    public StudentInCourse(String CourseID,String CourseName, ArrayList<LecturerSubset> lecturers ,ArrayList<StudentSubset> students){      
        this.CourseID =CourseID;
        this.CourseName =CourseName;
        this.lecturers = lecturers;
        this.students = students;
    }

    public String toString() {
        return "Course: " + CourseID +"_"+ CourseName + lecturers + students;
    }
    
    public void addStudent(StudentSubset student){
        students.add(student);
    }

    public void addLecturers(LecturerSubset LecSub) {
        lecturers.add(LecSub);
    }
}

class TestSystem {

    private static final String Student_In_Course_File = "StudentInCourse.dat";

    private static void saveStudentInCourseToFile(StudentInCourse studentInCourse) {
        studentInCourse.saveToFile(Student_In_Course_File);
    }

    private static StudentInCourse loadStudentInCourseFromFile() {
        return StudentInCourse.loadFromFile(Student_In_Course_File);
    }

    private static boolean checkPrerequisitesCompleted(Student student, List<Course> prerequisites) {
        return false; // Placeholder, replace it with your actual logic
    }

    private static void EnrollInTrimester(Student studentToEnroll, Course courseToEnroll, StudentInCourse siCourse,
    List<StudentSubset> subStudentList, int courseIndex, int studentIndex, int trimester, Scanner sc) {
    List<Course> prerequisites = courseToEnroll.getPrerequisites();
        if (checkPrerequisitesCompleted(studentToEnroll, prerequisites)) {
            switch (trimester) {
                case 1:
                    studentToEnroll.addCoursesToT1(courseToEnroll);
                    break;
                case 2:
                    studentToEnroll.addCoursesToT2(courseToEnroll);
                    break;
                case 3:
                    studentToEnroll.addCoursesToT3(courseToEnroll);
                    break;
                default:
                    System.out.println("Invalid trimester");
            }

            StudentSubset stuSub = subStudentList.get(studentIndex);
            siCourse.addStudent(stuSub);
            System.out.println(studentToEnroll.toString());
        } else {
            System.out.println("You have not completed the prerequisites for this course.");
        }

        System.out.print("Do you still want to enroll (Y/N): ");
        String confirmation = sc.nextLine();
        if (!confirmation.equalsIgnoreCase("Y")) {
            System.out.println("Enrollment canceled.");
        }
    }

    public static void main(String[] args) {

        List<Course> CourseList = new ArrayList<>();
        List<Student> StudentList = new ArrayList<>();
        List<Lecturer> LecturerList = new ArrayList<>();
        List<StudentInCourse> StudentInCourse = new ArrayList<>();
        List<LecturerSubset> subLecturerList = new ArrayList<>();
        List<StudentSubset> subStudentList = new ArrayList<>();

        int option;
        int profile = 0;
        int courseIndex = 0;
        int studentIndex = 0;
        Student studentToEnroll = StudentList.get(studentIndex);
        Course courseToEnroll = CourseList.get(courseIndex);
        String course;
        String id;
        String LecID;
        String CourseID;
        //String StuID;
        String name;
        String confirmation;
        boolean exitProgram = false;

        Scanner sc = new Scanner(System.in);
        StudentList.add(new Student("1211101453", "Lee",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        subStudentList.add(new StudentSubset("1211101453", "Lee"));
        LecturerList.add(new Lecturer("905488", "Steven",new ArrayList<>()));
        subLecturerList.add(new LecturerSubset("905488","Steven"));
        CourseList.add(new Course("C102","OOPDS", new ArrayList<>()));
        StudentInCourse.add(new StudentInCourse("C102","OOPDS", new ArrayList<>(), new ArrayList<>()));

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
                                System.out.println("5.Summary View");
                                System.out.println("6.Logout");
                                System.out.print("Enter your choice (1/2/3/4/5/6): ");
                                option = sc.nextInt();
                                sc.nextLine(); // Consume the newline
                                switch (option) {
                                    case 1:
                                        do {
                                            System.out.print("Please Enter Course ID: ");
                                            CourseID = sc.nextLine();
                                            System.out.print("Please Enter Course Name: ");
                                            name = sc.nextLine();
                                            System.out.print("Enter Prerequisite Course ID (separated by commas): ");
                                            String prerequisiteIds = sc.nextLine();
                                            List<Course> prerequisites = new ArrayList<>();
                                            CourseList.add(new Course(CourseID, name));
                                            StudentInCourse.add(new StudentInCourse(CourseID,name,new ArrayList<>(),new ArrayList<>()));
                                            System.out.println("Successfully added " + CourseID + " " + name);
                                            for (Course list : CourseList) {
                                                System.out.println(list.toString());
                                            }
                                            for (String prerequisiteId : prerequisiteIds.split(",")) {
                                                int index = searchCourseIdIndex(CourseList, prerequisiteId.trim());
                                                if (index != -1) {
                                                    prerequisites.add(CourseList.get(index));
                                                } else {
                                                    System.out.println("Prerequisite course with ID " + prerequisiteId + " not found.");
                                                }
                                            }
                                            CourseList.add(new Course(CourseID, name, prerequisites));
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
                                            subLecturerList.add(new LecturerSubset(LecID,name));
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
                                            CourseID = sc.nextLine();
                                            System.out.print("Enter LecturerID to assign to it: ");
                                            LecID = sc.nextLine();
                                            int Cindex = searchCourseIdIndex(CourseList,CourseID);
                                            int Lindex = searchLecturerIdIndex(LecturerList,LecID);
                                            Course Course = CourseList.get(Cindex);
                                            Lecturer Lecturer = LecturerList.get(Lindex);
                                            LecturerSubset LecSub = subLecturerList.get(Lindex);
                                            StudentInCourse siCourse = StudentInCourse.get(Cindex);
                                            Lecturer.addCourses(Course);
                                            siCourse.addLecturers(LecSub);
                                            System.out.println(LecturerList.get(Lindex));
                                            System.out.print("Do you still want to assign (Y/N): ");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("Y"));
                                        break;
                                    case 5:
                                        System.out.println(StudentInCourse);
                                    break;
                                    case 6:
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
                                        System.out.println("1. Trimester I");
                                        System.out.println("2. Trimester II");
                                        System.out.println("3. Trimester III");
                                        System.out.println("4. Back");
                                        System.out.print("Enter your choice (1/2/3/4): ");
                                    
                                        boolean exitEnrollMenu = false;
                                        int trimesterOption = sc.nextInt();
                                        sc.nextLine(); // consume the newline
                                    
                                        switch (trimesterOption) {
                                            case 1:
                                                // Enroll in Trimester I 
                                                EnrollInTrimester(studentToEnroll, courseToEnroll, StudentInCourse.get(courseIndex), subStudentList, courseIndex, studentIndex, 1, sc);
                                                break;
                                            case 2:
                                                // Enroll in Trimester II
                                                EnrollInTrimester(studentToEnroll, courseToEnroll, StudentInCourse.get(courseIndex), subStudentList, courseIndex, studentIndex, 2, sc);
                                                break;
                                            case 3:
                                                // Enroll in Trimester III
                                                EnrollInTrimester(studentToEnroll, courseToEnroll, StudentInCourse.get(courseIndex), subStudentList, courseIndex, studentIndex, 3, sc);
                                                break;
                                            case 4:
                                                break;
                                            default:
                                                System.out.println("Invalid option, Please Select Again");
                                        }
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
                        LecID = sc.nextLine();
                        boolean foundLecturer = searchLecturerID(LecturerList, LecID);
                        if (foundLecturer) {
                            System.out.println("Welcome Lecturer " + LecID);
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
        saveStudentInCourseToFile(StudentInCourse.get(0)); // Save example
        StudentInCourse loadedData = loadStudentInCourseFromFile(); 
    }

    // To identify Student
    public static boolean searchStudentID(List<Student> StudentList, String SID) {
        for (Student StudentID : StudentList) {
            if (StudentID.getId().equals(SID))
                return true;
        }
        return false;
    }

    // To identify Lecturer
    public static boolean searchLecturerID(List<Lecturer> LecturerList, String LecID) {
        for (Lecturer LecturerID : LecturerList) {
            if (LecturerID.getId().equals(LecID))
                return true;
        }
        return false;
    }

    // Get CourseID index
    public static int searchCourseIdIndex(List<Course> CourseList, String CourseID) {
    for (int i = 0; i < CourseList.size(); i++) {
        if (CourseList.get(i).getId().equals(CourseID)) {
            return i; // Return the index when the course ID is found
        }
    }
    return -1; // Return -1 if the course ID is not found in the list
    }

    // Get LecturerID index
    public static int searchLecturerIdIndex(List<Lecturer> LecturerList, String LecID) {
    for (int i = 0; i < LecturerList.size(); i++) {
        if (LecturerList.get(i).getId().equals(LecID)) {
            return i; // Return the index when the course ID is found
        }
    }
    return -1; // Return -1 if the lecturer ID is not found in the list
    }

    // Get StudentID index
    public static int searchStudentIdIndex(List<Student> StudentList, String LecID) {
    for (int i = 0; i < StudentList.size(); i++) {
        if (StudentList.get(i).getId().equals(LecID)) {
            return i; // Return the index when the course ID is found
        }
    }
    return -1; // Return -1 if the student ID is not found in the list
    }
}
