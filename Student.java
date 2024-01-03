public class Student {
    private int ID;
    private String Name;
    
    public Student(int ID, String Name){
        this.ID = ID;
        this.Name = Name;
    }

    public int getID(){
        return ID;
    }

    public String toString(){
        return ID + " " + Name;
    }
}
