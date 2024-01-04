import java.util.Set;
import java.util.TreeSet;

public class Lecturer {

    private String name;
    private Set<String> IDCourse = new TreeSet<>();

    public Lecturer(String name) {
        this.name = name;
    }
    public Set<String> addCourse(String courseToAdd) {
        IDCourse.add(courseToAdd);
        return IDCourse;
    }
    public String toString() {
        return "Name = " + name + " , Course = " + IDCourse;
    }
    

}

class TestLecturer {
    public static void main(String[] args) {
        Lecturer a = new Lecturer("Lee");
        Lecturer b = new Lecturer("Wong");
        a.addCourse("TMA2201");
        a.addCourse("TCP2201");
        b.addCourse("TTC2001");
        b.addCourse("TCD2010");
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}
