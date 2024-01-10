import java.util.Set;
import java.util.TreeSet;

public class Lecturer {
    private String IDLecture;
    private String name;
    private Set<String> IDCourse = new TreeSet<>();

    public Lecturer(String ID, String name) {
        this.IDLecture = ID;
        this.name = name;
    }
    public String getID () {
        return IDLecture;
    }
    public String getName () {
        return name;
    }
    public Set<String> getCourse () {
        return IDCourse;
    }

    void addCourse(String courseToAdd) {
        IDCourse.add(courseToAdd);
    }
    public String printLecture() {
        return "ID = " + IDLecture + "Name = " + name + " , Course = " + IDCourse;
    }
    
}
