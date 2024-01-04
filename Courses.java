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
