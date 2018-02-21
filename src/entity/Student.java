package entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private double averageScore;
    private boolean isWantToBeLeader;
    private StudentType studentType;
    private GroupName groupName;
    private Set<Lesson> lessons = new HashSet<>();

    public Student(long id, String firstName, String lastName, double averageScore, boolean isWantToBeLeader, StudentType studentType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.averageScore = averageScore;
        this.isWantToBeLeader = isWantToBeLeader;
        this.studentType = studentType;
    }

    public Student(long id, String firstName, String lastName, double averageScore, boolean isWantToBeLeader, StudentType studentType, GroupName groupName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.averageScore = averageScore;
        this.isWantToBeLeader = isWantToBeLeader;
        this.studentType = studentType;
        this.groupName = groupName;
    }

    public void addLesson(Lesson lesson) {
        if (lesson != null)
            this.lessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        if (lesson != null)
            this.lessons.remove(lesson);
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public boolean isWantToBeLeader() {
        return isWantToBeLeader;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public GroupName getGroup() {
        return groupName;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }

    public void setGroupName(GroupName groupName) {
        if (groupName != null) {
            this.groupName = groupName;
        }
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", averageScore=" + averageScore +
                ", isWantToBeLeader=" + isWantToBeLeader +
                ", studentType=" + studentType +
                ", groupName=" + groupName +
                ", lessons=" + lessons +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
