package dao;

import entity.GroupName;
import entity.Student;
import entity.StudentType;

import java.util.*;

public class StudentDAO extends GeneralDAO<Student> {

    private static StudentDAO instance;


    public static StudentDAO getInstance() throws Exception {
        if (instance == null)
            instance = new StudentDAO();
        return instance;
    }

    public StudentDAO() throws Exception {
        add(new Student(1, "John", "Smith", 4.1, true, StudentType.ORDINARY_STUDENT, GroupName.GROUP_101));
        add(new Student(2, "David", "Black", 4.4, true, StudentType.ORDINARY_STUDENT,GroupName.GROUP_101));
        add(new Student(3, "Mark", "Brown", 3.1, true, StudentType.ORDINARY_STUDENT, GroupName.GROUP_102));
        add(new Student(4, "Piter", "Green", 4.1, true, StudentType.ORDINARY_STUDENT, GroupName.GROUP_102));
        add(new Student(5, "Max", "Yellow", 4.5, true, StudentType.ORDINARY_STUDENT, GroupName.GROUP_103));
        add(new Student(6, "Piter", "White", 4.6, true, StudentType.ORDINARY_STUDENT, GroupName.GROUP_103));
        add(new Student(7, "John", "Douson", 5.0, false, StudentType.ORDINARY_STUDENT, GroupName.GROUP_101));


    }


    public Student addStudentToGroup(Student student, GroupName groupName) throws Exception {
        if (student == null || groupName == null) throw new NullPointerException("Input data is null");



        for (Student student1 : getAll()) {
            if (student1 != null && student1.equals(student) && !student1.getGroup().equals(groupName)) {
                student1.setGroupName(groupName);

            }
        }

        return student;
    }

    public List<Student> getStudentsByGroupName(GroupName groupName)  {
        if (groupName == null) throw new NullPointerException("Input data is null");

        List<Student> students = new LinkedList<>();


        for (Student student : getAll()) {
            if (student != null && student.getGroup()==(groupName)) {
                students.add(student);
            }
        }
        return students;
    }


    @Override
    public Student add(Student student) {

        return super.add(student);
    }

    @Override
    public void remove(Student student) {
        super.remove(student);
    }

    @Override
    public Set<Student> getAll() {
        return super.getAll();
    }


}
