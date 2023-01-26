import java.time.LocalTime;
import java.util.Arrays;

public class Group {

    private String name;
    private LocalTime groupTime;
    private Student[] students;
    private Course course;
    private Mentor mentor;

    public Group() {
    }

    public Group(String name, LocalTime groupTime, Student[] students, Course course, Mentor mentor) {
        this.name = name;
        this.groupTime = groupTime;
        this.students = students;
        this.course = course;
        this.mentor = mentor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getGroupTime() {
        return groupTime;
    }

    public void setGroupTime(LocalTime groupTime) {
        this.groupTime = groupTime;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", groupTime=" + groupTime +
                ", students=" + Arrays.toString(students) +
                ", course=" + course +
                ", mentor=" + mentor +
                '}';
    }
}
