package org.example;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "courses")
public class Course {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String title;

    private int duration;

    public int getId() {
        return id;
    }

    public Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course() {

    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }

    public void  updateName(String title){
        this.title = title;
    }
}
