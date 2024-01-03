import java.util.*;

public class CourseManagementSystem{
    public static void main(String[] args) {
        System.out.println("Welcome to Course Manager");
        System.out.println("Please Select your Profile: [1=Admin, 2=Student, 3=Teacher] ");
        Scanner sc = new Scanner (System.in);
        int Profile = sc.nextInt();

        while (Profile != 1/2/3)
            if (Profile == 1)
            System.out.println("Welcome, Admin");
            else if (Profile == 2)
            System.out.println("Welcome, Student");
            else if (Profile == 3)
            System.out.println("Welcome, Teacher");    
            else
            System.out.println("Please input numbers 1, 2 or 3");

            
            
    }
}
