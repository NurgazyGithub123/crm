package model;

import java.time.LocalTime;
import java.util.Arrays;

public final class Group extends BaseEntity{

    private String name;
    private LocalTime groupTime;
    private Student[] students;
    private Course course;
    private Mentor mentor;

    public Group() {
    }

}
