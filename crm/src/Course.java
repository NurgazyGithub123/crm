public class Course {

    private String courseName;
    private int durationCourse;
    private String typeCourse;
    private double priceCourse;

    public Course() {
    }

    public Course(String courseName, int durationCourse, String typeCourse, double priceCourse) {
        this.courseName = courseName;
        this.durationCourse = durationCourse;
        this.typeCourse = typeCourse;
        this.priceCourse = priceCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDurationCourse() {
        return durationCourse;
    }

    public void setDurationCourse(int durationCourse) {
        this.durationCourse = durationCourse;
    }

    public String getTypeCourse() {
        return typeCourse;
    }

    public void setTypeCourse(String typeCourse) {
        this.typeCourse = typeCourse;
    }

    public double getPriceCourse() {
        return priceCourse;
    }

    public void setPriceCourse(double priceCourse) {
        this.priceCourse = priceCourse;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", durationCourse=" + durationCourse +
                ", typeCourse='" + typeCourse + '\'' +
                ", priceCourse=" + priceCourse +
                '}';
    }
}
