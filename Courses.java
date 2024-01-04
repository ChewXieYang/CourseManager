import java.io.*;
import java.util.*;

public class Courses {
    private int Credit;
    private String Code;
    private String PreReq;

    public Course(int Credit, String Code, String PreReq){
        this.Credit = Credit;
        this.Code = Code;
        this.PreReq = PreReq;
    }

    public int getCredit(){
        return Credit;
    }
    public String getCode(){
        return Code;
    }
    public String getPreReq(){
        return PreReq;
    }
}

class CourseFile{
    public static void main(String[] args){
    String CourseFile = "Courses.csv";

    try{
    Scanner scanner = new Scanner(new File(CourseFile));
    LinkedList<String[]> CourseData = new LinkedList<>();

    while(scanner.hasNextLine()){
        String[] line = scanner.nextLine().split(",");
        CourseData.add(line);
    }

    for (String[] row: CourseData){
        for(String value : row){
            System.out.print(value + "\t");
        }
        System.out.println();
    }
    scanner.close();
    } catch(FileNotFoundException e){
        e.printStackTrace();
    }
}
