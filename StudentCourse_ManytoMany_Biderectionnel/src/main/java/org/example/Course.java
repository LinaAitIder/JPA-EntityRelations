package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    protected String courseName;



    @ManyToMany(mappedBy="courses")
    @JoinTable (
            name="STUDENT_COURSE",
            joinColumns=@JoinColumn(name="STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name="COURSE_ID")
    )
    private Collection<Student> students = new ArrayList<Student>();


    //setters and getter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students)
        {
        this.students = students;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
