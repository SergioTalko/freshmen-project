package dao;

import entity.Lesson;
import entity.Professor;
import entity.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ProfessorDAO extends GeneralDAO<Professor> {

    private static ProfessorDAO instance;


    public static ProfessorDAO getInstance() {
        if (instance == null)
            instance = new ProfessorDAO();
        return instance;
    }

    public ProfessorDAO() {
        add(new Professor(1, "Bill", "Green"));
        add(new Professor(2, "Micael", "Smith"));
        add(new Professor(3, "Gil", "Brown"));
    }


    public Professor findProfessorByName(String firstName, String lastName) {
        if (firstName == null || lastName == null) throw new NullPointerException("Input data is null");

        for (Professor professor : getAll()) {
            if (professor.getFirstName().equals(firstName) && professor.getLastName().equals(lastName)) {
                return professor;
            }
        }
        return null;
    }

    public void checkAbsentStudentOnLesson(Lesson lesson, long studentId) throws Exception {


        for (Student student : StudentDAO.getInstance().getStudentsByGroupName(lesson.getGroup().getGroupName())) {
            if (student != null && student.getId() == studentId) {
                student.removeLesson(lesson);
            }
        }

    }

    public int sumAvailableStudentOnLesson(Lesson lesson) throws Exception {
        if (lesson == null) throw new NullPointerException("Input data is null");

        int count = 0;
        for (Student student : StudentDAO.getInstance().getStudentsByGroupName(lesson.getGroup().getGroupName())) {
            if (student.getLessons().contains(lesson)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Professor add(Professor professor) {
        return super.add(professor);
    }

    @Override
    public void remove(Professor professor) {
        super.remove(professor);
    }

    @Override
    public Set<Professor> getAll() {
        return super.getAll();
    }
}
