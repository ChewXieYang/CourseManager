import java.io.*;
import java.util.*;

public class Courses {
    private int Credit;
    private String Code;
    private String PreReq;
    private List<Courses> prerequisites;

    // Constructor, getters, setters
    public Courses(int Credit, String Code, String PreReq){
        this.Credit = Credit;
        this.Code = Code;
        this.PreReq = PreReq;
        this.prerequisites = new ArrayList<>();
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
    public List<Courses> getPrerequisites() {
        return prerequisites;
    }
}
