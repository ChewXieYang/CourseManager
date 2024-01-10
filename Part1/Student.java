public class Student {
    private String Name;
    private String IDStudent;
    
    public Student(String ID, String Name){
        this.IDStudent = ID;
        this.Name = Name;
    }

    public String getID(){
        return IDStudent;
    }

    public String toString(){
        return Name;
    }

    public String printStudent(){
        return "ID = " + IDStudent + ", Name = " + Name;
    }

}
