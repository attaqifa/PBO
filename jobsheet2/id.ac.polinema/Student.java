import java.util.PrimitiveIterator;

public class Student {
    private String name;
    private String StudentId;
    private double gpa;

    Student(String name, String StudentId, double gpa){
        this.name = name;
        this.StudentId = StudentId;
        this.gpa = gpa;
    }

    public String describe(){
        return name + " ( " + StudentId + ", GPA " + gpa + " ) ";
    }
}
