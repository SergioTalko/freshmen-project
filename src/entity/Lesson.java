package entity;

import java.util.Date;
import java.util.Objects;

public class Lesson {
    private long id;
    private LessonType lessonType;
    private Date date;
    private Professor professor;
    private Group group;


    public Lesson(long id, LessonType lessonType, Date date, Professor professor, Group group) {
        this.id = id;
        this.lessonType = lessonType;
        this.date = date;
        this.professor = professor;
        this.group = group;

    }

    public long getId() {
        return id;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public Date getDate() {
        return date;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", lessonType=" + lessonType +
                ", date=" + date +
                ", professor=" + professor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id == lesson.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
